package com.ajidres.myapplication.di

import com.ajidres.myapplication.data.api.EndPoints
import com.ajidres.myapplication.data.api.EndPointsAccess
import com.ajidres.myapplication.data.api.repository.AccessRepositoryImpl
import com.ajidres.myapplication.data.api.repository.FeedRepositoryImpl
import com.ajidres.myapplication.domain.repository.AccessRepository
import com.ajidres.myapplication.domain.repository.FeedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAccessRepository(apis: EndPointsAccess): AccessRepository {
        return AccessRepositoryImpl(apis)
    }

    @Provides
    fun provideFeedRepository(apis: EndPoints): FeedRepository {
        return FeedRepositoryImpl(apis)
    }

}