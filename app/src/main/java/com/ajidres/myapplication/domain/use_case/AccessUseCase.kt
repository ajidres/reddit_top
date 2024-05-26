package com.ajidres.myapplication.domain.use_case

import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.domain.model.AccessEntity
import kotlinx.coroutines.flow.Flow

interface AccessUseCase {

    fun invokeAccess(code: String): Flow<ResultEndpoints<AccessEntity>>

}