package com.econrich.api.controller

import com.econrich.api.dto.EmployeeDto
import com.econrich.api.dto.EmployeeHistoryDto
import com.econrich.api.dto.EmployeeSalaryDto
import com.econrich.api.dto.EmployeeUpdateDto
import com.econrich.api.service.EmployeeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/employee")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getAllEmployees(@PageableDefault(size = 10, sort = ["employeeId"], direction = Sort.Direction.ASC) pageable: Pageable): Page<EmployeeDto> {
        return employeeService.getAllEmployees(pageable)
    }

    @GetMapping("/{id}")
    fun getEmployee(@PathVariable id: Int): EmployeeDto {
        return employeeService.getEmployeeToDto(id)
    }

    @GetMapping("/history/{id}")
    fun getEmployeeHistory(@PathVariable id: Int): EmployeeHistoryDto {
        return employeeService.getEmployeeHistoryToDto(id)
    }

    @PatchMapping("/{id}")
    fun updateEmployee(
        @PathVariable id: Int,
        @RequestBody dto: EmployeeUpdateDto
    ): EmployeeDto {
        return employeeService.updateEmployee(id, dto);
    }

    @PatchMapping("/salary")
    fun updateEmployeeSalary(
        @RequestBody dto: EmployeeSalaryDto
    ): List<EmployeeDto> {
        return employeeService.updateSalaries(dto);
    }
}