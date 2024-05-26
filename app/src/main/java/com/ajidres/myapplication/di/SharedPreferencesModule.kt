package com.ajidres.myapplication.di

import android.content.Context
import com.ajidres.myapplication.data.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object SharedPreferencesModule {

    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context): AppPreferences {
        val preferences = AppPreferences.getSharedPreferences(context)
        return AppPreferences(preferences)
    }

}