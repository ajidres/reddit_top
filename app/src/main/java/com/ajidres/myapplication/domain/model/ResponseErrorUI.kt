package com.ajidres.myapplication.domain.model

data class ResponseErrorUI(
    var errorCode: Int = 0,
    var description: String = "",
    var message: String = "",
)