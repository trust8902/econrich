package com.econrich.api.dto

import com.econrich.api.domain.Employee

data class EmployeeHistoryDto(
    var employeeId: Int,
    var firstName: String,
    var lastName: String,
    var email: String,
    var phoneNumber: String,
    var jobHistories: List<JobHistoryDto>,
) {
    companion object {
        fun fromEmployee(employee: Employee): EmployeeHistoryDto {
            return EmployeeHistoryDto(
                employeeId = employee.employeeId,
                firstName = employee.firstName ?: "",
                lastName = employee.lastName ?: "",
                email = employee.email ?: "",
                phoneNumber = employee.phoneNumber ?: "",
                jobHistories = employee.jobHistories.map { JobHistoryDto.fromJobHistory(it) }
            )
        }
    }
}
