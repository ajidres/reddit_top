package com.ajidres.myapplication.data.api.repository

import com.ajidres.myapplication.data.api.EndPoints
import com.ajidres.myapplication.data.api.mapper.toEntity
import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.domain.model.ChildrenFeedDataEntity
import com.ajidres.myapplication.domain.repository.FeedRepository
import com.ajidres.myapplication.extentions.bodyOrException
import com.ajidres.myapplication.extentions.getErrorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(private val apis: EndPoints) : FeedRepository {


    override fun fetchFeed(page: Int): Flow<ResultEndpoints<List<ChildrenFeedDataEntity>>> {
        return flow<ResultEndpoints<List<ChildrenFeedDataEntity>>> {
            val response = apis.feed(limit = page).bodyOrException()
            emit(ResultEndpoints.Success(response.toEntity()))
        }.onStart {
            emit(ResultEndpoints.Loading(true))
        }.onCompletion {

        }.catch {
            emit(ResultEndpoints.Loading(false))
            emit(ResultEndpoints.Failure(errorMessage = it.getErrorResponse()))
        }.flowOn(Dispatchers.IO)
    }

}