package com.ajidres.myapplication.domain.model


data class AccessEntity(
    val accessToken: String,
    val expiresIn: Int,
    val refreshToken: String,
)