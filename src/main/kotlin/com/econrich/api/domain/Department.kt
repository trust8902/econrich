package com.econrich.api.domain

import jakarta.persistence.*

@Entity(name = "departments")
class Department {

    @Id
    @Column(name = "department_id", nullable = false)
    var departmentId: Int = 0

    @Column(length = 30, nullable = false)
    var departmentName: String? = null

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id", nullable = false)
    var manager: Employee? = null

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    var location: Location? = null
}