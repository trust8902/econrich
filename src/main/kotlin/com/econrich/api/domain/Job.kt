package com.econrich.api.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity(name = "jobs")
class Job {

    @Id
    @Column(name = "job_id", length = 10, nullable = false)
    var jobId: String? = null

    @Column(length = 35, nullable = false)
    var jobTitle: String? = null

    @Column(precision = 8, scale = 0)
    var minSalary: BigDecimal = BigDecimal.ZERO

    @Column(precision = 8, scale = 0)
    var maxSalary: BigDecimal = BigDecimal.ZERO

}