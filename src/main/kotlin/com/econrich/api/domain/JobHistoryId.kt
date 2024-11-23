package com.econrich.api.domain

import jakarta.persistence.Embeddable
import java.io.Serializable
import java.time.LocalDate

@Embeddable
data class JobHistoryId(
    var employeeId: Int = 0,
    var startDate: LocalDate = LocalDate.now(),
): Serializable
