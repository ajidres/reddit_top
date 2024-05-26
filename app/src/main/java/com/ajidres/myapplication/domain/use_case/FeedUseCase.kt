package com.ajidres.myapplication.domain.use_case

import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.domain.model.ChildrenFeedDataEntity
import kotlinx.coroutines.flow.Flow

interface FeedUseCase {

    fun invokeFeed(page: Int): Flow<ResultEndpoints<List<ChildrenFeedDataEntity>>>

}