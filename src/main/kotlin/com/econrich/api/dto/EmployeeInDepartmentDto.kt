package com.econrich.api.dto

import com.econrich.api.domain.Department
import com.econrich.api.domain.Location

data class EmployeeInDepartmentDto(
    var departmentId: Int,
    var departmentName: String,
    var location: Location,
) {
    companion object {
        fun fromDepartment(department: Department): EmployeeInDepartmentDto {
            return EmployeeInDepartmentDto(
                departmentId = department.departmentId,
                departmentName = department.departmentName ?: "",
                location = department.location ?: Location(),
            )
        }
    }
}
