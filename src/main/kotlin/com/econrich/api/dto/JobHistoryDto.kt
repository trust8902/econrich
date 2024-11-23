package com.econrich.api.dto

import com.econrich.api.domain.JobHistory
import com.econrich.api.domain.JobHistoryId
import java.time.LocalDate

data class JobHistoryDto(
    var id: JobHistoryId,
    var department: EmployeeInDepartmentDto?,
    var job: JobDto?,
    var endDate: LocalDate,
) {
    companion object {
        fun fromJobHistory(jobHistory: JobHistory): JobHistoryDto {
            return JobHistoryDto(
                id = jobHistory.id,
                department = jobHistory.department?.let { EmployeeInDepartmentDto.fromDepartment(it) },
                job = jobHistory.job?.let { JobDto.fromJob(it) },
                endDate = jobHistory.endDate ?: LocalDate.now(),
            )
        }
    }
}
