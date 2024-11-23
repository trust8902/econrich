package com.econrich.api.dto

import com.econrich.api.domain.Employee
import com.econrich.api.domain.Job
import java.math.BigDecimal
import java.time.LocalDate

data class ManagerDto(
    var employeeId: Int,
    var firstName: String,
    var lastName: String,
    var email: String,
    var phoneNumber: String,
    var hireDate: LocalDate,
    var salary: BigDecimal,
    var commissionPct: BigDecimal,
    var job: JobDto,
) {
    companion object {
        fun fromEmployee(employee: Employee): ManagerDto {
            return ManagerDto(
                employeeId = employee.employeeId,
                firstName = employee.firstName ?: "",
                lastName = employee.lastName ?: "",
                email = employee.email ?: "",
                phoneNumber = employee.phoneNumber ?: "",
                hireDate = employee.hireDate ?: LocalDate.now(),
                salary = employee.salary ?: BigDecimal.ZERO,
                commissionPct = employee.commissionPct ?: BigDecimal.ZERO,
                job = JobDto.fromJob(employee.job ?: Job()),
            )
        }
    }
}
