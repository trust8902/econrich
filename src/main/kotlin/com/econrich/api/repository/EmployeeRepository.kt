package com.econrich.api.repository

import com.econrich.api.domain.Department
import com.econrich.api.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<Employee, Int> {

    @Query("select e from employees e where e.department.departmentId=:departmentId")
    fun findDepartmentId(departmentId: Int): List<Employee>

}