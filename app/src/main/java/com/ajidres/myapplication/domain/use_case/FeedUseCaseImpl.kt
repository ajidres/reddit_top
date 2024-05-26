package com.ajidres.myapplication.domain.use_case


import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.domain.model.ChildrenFeedDataEntity
import com.ajidres.myapplication.domain.repository.FeedRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FeedUseCaseImpl @Inject constructor(private val apiRepository: FeedRepository) : FeedUseCase {

    override fun invokeFeed(page: Int): Flow<ResultEndpoints<List<ChildrenFeedDataEntity>>> = apiRepository.fetchFeed(page)


}