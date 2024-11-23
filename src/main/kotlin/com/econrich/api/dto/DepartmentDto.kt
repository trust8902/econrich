package com.econrich.api.dto

import com.econrich.api.domain.Department
import com.econrich.api.domain.Employee
import com.econrich.api.domain.Location

data class DepartmentDto(
    var departmentId: Int,
    var manager: ManagerDto,
    var departmentName: String,
    var location: Location,
) {
    companion object {
        fun fromDepartment(department: Department): DepartmentDto {
            return DepartmentDto(
                departmentId = department.departmentId,
                manager = ManagerDto.fromEmployee(department.manager ?: Employee()),
                departmentName = department.departmentName ?: "",
                location = department.location ?: Location(),
            )
        }
    }
}
