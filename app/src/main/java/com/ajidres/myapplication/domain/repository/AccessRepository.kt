package com.ajidres.myapplication.domain.repository

import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.domain.model.AccessEntity
import kotlinx.coroutines.flow.Flow

interface AccessRepository {

    fun grantAccess(code: String): Flow<ResultEndpoints<AccessEntity>>

}