package com.cm.mvparchitecture.data.network.model

data class ApiError (
    val httpErrorCode: Int?,
    val message: String
)