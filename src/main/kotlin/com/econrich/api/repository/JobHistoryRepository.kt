package com.econrich.api.repository

import com.econrich.api.domain.JobHistory
import com.econrich.api.domain.JobHistoryId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface JobHistoryRepository : JpaRepository<JobHistory, JobHistoryId> {
    @Query("SELECT t FROM job_history t WHERE t.employee.employeeId = :employeeId ORDER BY t.id.startDate DESC LIMIT 1")
    fun findLatestByEmployeeId(@Param("employeeId") employeeId: Int): JobHistory?
}