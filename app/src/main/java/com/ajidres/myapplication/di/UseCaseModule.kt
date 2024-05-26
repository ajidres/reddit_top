package com.ajidres.myapplication.di


import com.ajidres.myapplication.domain.repository.AccessRepository
import com.ajidres.myapplication.domain.repository.FeedRepository
import com.ajidres.myapplication.domain.use_case.AccessUseCase
import com.ajidres.myapplication.domain.use_case.AccessUseCaseImpl
import com.ajidres.myapplication.domain.use_case.FeedUseCase
import com.ajidres.myapplication.domain.use_case.FeedUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideAccessUseCase(
        apiRepository: AccessRepository,
    ): AccessUseCase {
        return AccessUseCaseImpl(apiRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideFeedUseCase(
        apiRepository: FeedRepository,
    ): FeedUseCase {
        return FeedUseCaseImpl(apiRepository)
    }


}