package com.ajidres.myapplication.data.api.mapper

import com.ajidres.myapplication.data.api.model.AccessModel
import com.ajidres.myapplication.domain.model.AccessEntity


fun AccessModel.toEntity(): AccessEntity =
    with(this) {
        return AccessEntity(
            accessToken = accessToken ?: "",
            expiresIn = expiresIn ?: 0,
            refreshToken = refreshToken ?: "",
        )
    }
