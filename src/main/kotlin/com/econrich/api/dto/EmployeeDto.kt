package com.econrich.api.dto

import com.econrich.api.domain.Employee
import java.math.BigDecimal
import java.time.LocalDate

data class EmployeeDto(
    var employeeId: Int,
    var firstName: String,
    var lastName: String,
    var email: String,
    var phoneNumber: String,
    var hireDate: LocalDate,
    var salary: BigDecimal,
    var commissionPct: BigDecimal,
    var job: JobDto?,
    var manager: ManagerDto?,
    var department: EmployeeInDepartmentDto?,
) {
    companion object {
        fun fromEmployee(employee: Employee): EmployeeDto {
            return EmployeeDto(
                employeeId = employee.employeeId,
                firstName = employee.firstName ?: "",
                lastName = employee.lastName ?: "",
                email = employee.email ?: "",
                phoneNumber = employee.phoneNumber ?: "",
                hireDate = employee.hireDate ?: LocalDate.now(),
                salary = employee.salary ?: BigDecimal.ZERO,
                commissionPct = employee.commissionPct ?: BigDecimal.ZERO,
                job = employee.job?.let { JobDto.fromJob(it) },
                manager = employee.manager?.let { ManagerDto.fromEmployee(it) },
                department = employee.department?.let { EmployeeInDepartmentDto.fromDepartment(it) },
            )
        }
    }
}
