package com.ajidres.myapplication.domain.repository

import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.domain.model.ChildrenFeedDataEntity
import kotlinx.coroutines.flow.Flow

interface FeedRepository {

    fun fetchFeed(page: Int): Flow<ResultEndpoints<List<ChildrenFeedDataEntity>>>

}