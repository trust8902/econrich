package com.econrich.api.common.response

data class ApiResponse<T>(
    val statusCode: Int,
    val data: T,
)
