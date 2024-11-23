package com.econrich.api.domain

import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "job_history")
class JobHistory {

    @EmbeddedId
    var id: JobHistoryId = JobHistoryId()

    @MapsId("employeeId")
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    var employee: Employee?= null

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    var department: Department?= null

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    var job: Job?= null

    @Column(nullable = false)
    var endDate: LocalDate? = null
}