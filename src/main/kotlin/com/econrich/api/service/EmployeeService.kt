package com.econrich.api.service

import com.econrich.api.domain.Employee
import com.econrich.api.domain.JobHistory
import com.econrich.api.domain.JobHistoryId
import com.econrich.api.dto.EmployeeDto
import com.econrich.api.dto.EmployeeHistoryDto
import com.econrich.api.dto.EmployeeSalaryDto
import com.econrich.api.dto.EmployeeUpdateDto
import com.econrich.api.repository.DepartmentRepository
import com.econrich.api.repository.EmployeeRepository
import com.econrich.api.repository.JobHistoryRepository
import com.econrich.api.repository.JobRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val departmentRepository: DepartmentRepository,
    private val jobRepository: JobRepository,
    private val jobHistoryRepository: JobHistoryRepository,
) {

    fun getAllEmployees(pageable: Pageable): Page<EmployeeDto> {
        val employees = employeeRepository.findAll(pageable)
        return employees.map { EmployeeDto.fromEmployee(it) }
    }

    fun getEmployee(id: Int): Employee {
        return employeeRepository.findById(id).orElseThrow {
            NoSuchElementException("No employee with id $id")
        }
    }

    fun getEmployeeToDto(id: Int): EmployeeDto {
        return EmployeeDto.fromEmployee(getEmployee(id));
    }

    fun getEmployeeHistoryToDto(id: Int): EmployeeHistoryDto {
        return EmployeeHistoryDto.fromEmployee(employeeRepository.findById(id).orElseThrow {
            NoSuchElementException("No employee with id $id")
        });
    }

    @Transactional
    fun updateEmployee(id: Int, dto: EmployeeUpdateDto): EmployeeDto {
        val employee = getEmployee(id)

        dto.firstName?.let { employee.firstName = it }
        dto.lastName?.let { employee.lastName = it }
        dto.email?.let { employee.email = it }
        dto.phoneNumber?.let { employee.phoneNumber = it }
        dto.hireDate?.let { employee.hireDate = it }
        dto.salary?.let { employee.salary = it }
        dto.commissionPct?.let { employee.commissionPct = it }

        val currentJob = employee.job
        val currentDepartment = employee.department

        if ((currentJob != null && (currentJob.jobId != dto.jobId)) ||
            (currentDepartment != null && (currentDepartment.departmentId != dto.departmentId))) {
            val latestJobHistory = jobHistoryRepository.findLatestByEmployeeId(id)

            val jobHistory = JobHistory().apply {
                val startDate = latestJobHistory?.endDate?.takeIf { it == LocalDate.now() }
                    ?: latestJobHistory?.endDate?.plusDays(1)
                    ?: employee.hireDate

                this.id = JobHistoryId(
                    employeeId = id,
                    startDate = startDate ?: LocalDate.now(),
                )
                this.employee = employee
                this.job = currentJob
                this.department = currentDepartment
                this.endDate = LocalDate.now()
            }
            jobHistoryRepository.save(jobHistory)
        }

        dto.jobId?.let { jobId ->
            val job = jobRepository.findById(jobId).orElseThrow {
                NoSuchElementException("Job with jobId $jobId not found")
            }

            employee.job = job
        }

        dto.managerId?.let { managerId ->
            val manager = getEmployee(managerId)

            employee.manager = manager
        }

        dto.departmentId?.let { departmentId ->
            val department = departmentRepository.findById(departmentId).orElseThrow {
                NoSuchElementException("Department with id $departmentId not found")
            }

            employee.department = department
        }

        return getEmployeeToDto(id)
    }

    @Transactional
    fun updateSalaries(dto: EmployeeSalaryDto): List<EmployeeDto> {
        val employees = employeeRepository.findDepartmentId(dto.departmentId).map { employee ->
            val percentage = (BigDecimal(dto.percentage).divide(BigDecimal(100)) + BigDecimal.ONE)
            employee.salary = employee.salary.multiply(percentage).setScale(2, RoundingMode.HALF_UP)
            employee
        }

        employeeRepository.saveAll(employees)

        return employees.map { EmployeeDto.fromEmployee(it) }
    }
}