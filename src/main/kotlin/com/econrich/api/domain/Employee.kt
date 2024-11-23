package com.econrich.api.domain

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity(name = "employees")
class Employee {

    @Id
    @Column(name = "employee_id", nullable = false)
    var employeeId: Int = 0

    @Column(length = 20)
    var firstName: String? = null

    @Column(length = 25, nullable = false)
    var lastName: String? = null

    @Column(length = 25, nullable = false)
    var email: String? = null

    @Column(length = 20)
    var phoneNumber: String? = null

    @Column(nullable = false)
    var hireDate: LocalDate? = null

    @Column(precision = 8, scale = 2, nullable = false)
    var salary: BigDecimal = BigDecimal("0.00")

    @Column(precision = 2, scale = 2)
    var commissionPct: BigDecimal = BigDecimal("0.00")

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    var department: Department? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    var job: Job? = null

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    var jobHistories: MutableList<JobHistory> = mutableListOf()

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = false)
    var manager: Employee? = null

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    var employees: MutableList<Employee> = mutableListOf()
}