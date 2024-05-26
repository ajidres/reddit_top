package com.ajidres.myapplication.data.api.model

import com.ajidres.myapplication.domain.model.ResponseErrorUI


sealed class ResultEndpoints<out T> {
    data class Success<T>(val data: T) : ResultEndpoints<T>()
    data class Loading<T>(val show: Boolean) : ResultEndpoints<T>()
    data class Failure<T>(val errorMessage: ResponseErrorUI?) : ResultEndpoints<T>()
}