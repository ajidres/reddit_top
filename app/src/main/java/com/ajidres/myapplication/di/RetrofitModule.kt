package com.ajidres.myapplication.di

import com.ajidres.myapplication.BuildConfig.CLIENT_ID
import com.ajidres.myapplication.BuildConfig.DEBUG
import com.ajidres.myapplication.BuildConfig.URL_BASE
import com.ajidres.myapplication.BuildConfig.URL_BASE_OAUTH
import com.ajidres.myapplication.data.AppPreferences
import com.ajidres.myapplication.data.api.EndPoints
import com.ajidres.myapplication.data.api.EndPointsAccess
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private val TIME_CONNECTION = 1L


    @Provides
    @Singleton
    fun provideApiAccess(): EndPointsAccess {

        val httpClient: OkHttpClient = httpClient()
            .addInterceptor { chain ->
                val request: Request = chain.request()
                val authenticatedRequest: Request = request.newBuilder()
                    .header("Authorization", Credentials.basic(CLIENT_ID, "")).build()
                chain.proceed(authenticatedRequest)
            }
            .build()


        return clientRetrofit(httpClient, URL_BASE).build()
            .create(EndPointsAccess::class.java)
    }

    @Provides
    @Singleton
    fun provideApi(appPreferences: AppPreferences): EndPoints {

        val httpClient: OkHttpClient = httpClient()
            .addInterceptor { chain ->
                val request: Request = chain.request()
                val authenticatedRequest: Request = request.newBuilder()
                    .header("Authorization", "Bearer ${appPreferences.token}").build()
                chain.proceed(authenticatedRequest)
            }
            .build()


        return clientRetrofit(httpClient, URL_BASE_OAUTH).build()
            .create(EndPoints::class.java)
    }

    private fun clientRetrofit(httpClient: OkHttpClient, url: String): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .client(httpClient)

    }

    private fun httpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .readTimeout(TIME_CONNECTION, TimeUnit.MINUTES)
            .writeTimeout(TIME_CONNECTION, TimeUnit.MINUTES)
            .connectTimeout(TIME_CONNECTION, TimeUnit.MINUTES)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = if (DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                }
            )
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .addHeader("User-Agent", "android-reddit-test").build()
                )
            }
    }
}