package com.econrich.api.dto

import com.econrich.api.domain.Job
import java.math.BigDecimal

data class JobDto(
    var jobId: String,
    var jobTitle: String,
    var minSalary: BigDecimal,
    var maxSalary: BigDecimal,
) {
    companion object {
        fun fromJob(job: Job): JobDto {
            return JobDto(
                jobId = job.jobId ?: "",
                jobTitle = job.jobTitle ?: "",
                minSalary = job.minSalary ?: BigDecimal.ZERO,
                maxSalary = job.maxSalary ?: BigDecimal.ZERO,
            )
        }
    }
}
