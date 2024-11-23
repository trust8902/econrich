package com.econrich.api.service

import com.econrich.api.dto.DepartmentDto
import com.econrich.api.repository.DepartmentRepository
import org.springframework.stereotype.Service

@Service
class DepartmentService(private val departmentRepository: DepartmentRepository) {

    fun getDepartment(id: Int): DepartmentDto {
        return DepartmentDto.fromDepartment(departmentRepository.findById(id).orElseThrow {
            NoSuchElementException("No employee with id $id")
        })
    }

}