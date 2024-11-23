package com.econrich.api.controller

import com.econrich.api.domain.Department
import com.econrich.api.dto.DepartmentDto
import com.econrich.api.service.DepartmentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/department")
class DepartmentController(private val departmentService: DepartmentService) {

    @GetMapping("/{id}")
    fun getDepartment(@PathVariable("id") id: Int): DepartmentDto {
        return departmentService.getDepartment(id)
    }

}