package com.ajidres.myapplication.domain.use_case


import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.domain.model.AccessEntity
import com.ajidres.myapplication.domain.repository.AccessRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AccessUseCaseImpl @Inject constructor(private val apiRepository: AccessRepository) : AccessUseCase {

    override fun invokeAccess(code: String): Flow<ResultEndpoints<AccessEntity>> = apiRepository.grantAccess(code)


}