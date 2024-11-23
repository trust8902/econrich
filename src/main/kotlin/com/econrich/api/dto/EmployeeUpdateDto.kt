package com.econrich.api.dto

import java.math.BigDecimal
import java.time.LocalDate

data class EmployeeUpdateDto(
    var firstName: String?,
    var lastName: String?,
    var email: String?,
    var phoneNumber: String?,
    var hireDate: LocalDate?,
    var salary: BigDecimal?,
    var commissionPct: BigDecimal?,
    var jobId: String?,
    var managerId: Int?,
    var departmentId: Int?,
)
