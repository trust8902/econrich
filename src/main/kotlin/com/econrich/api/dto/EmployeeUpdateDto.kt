package com.econrich.api.dto

import jakarta.validation.constraints.Email
import java.math.BigDecimal
import java.time.LocalDate

data class EmployeeUpdateDto(
    var firstName: String?,
    var lastName: String?,

    @field:Email(message = "Invalid email format")
    var email: String?,
    var phoneNumber: String?,
    var hireDate: LocalDate?,
    var salary: BigDecimal?,
    var commissionPct: BigDecimal?,
    var jobId: String?,
    var managerId: Int?,
    var departmentId: Int?,
)
