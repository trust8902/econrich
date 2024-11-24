package com.econrich.api.dto

import jakarta.validation.constraints.*

data class EmployeeSalaryDto(
    @field:NotNull(message = "DepartmentId cannot be null")
    var departmentId: Int,

    @field:NotNull(message = "Percentage cannot be null")
    @field:Min(value = 0, message = "Percentage value must be greater than 0")
    @field:Max(value = 100, message = "Percentage value must be less than 100")
    var percentage: Int,
)
