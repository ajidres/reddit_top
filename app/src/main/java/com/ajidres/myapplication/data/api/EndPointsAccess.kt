package com.ajidres.myapplication.data.api

import com.ajidres.myapplication.BuildConfig.REDIRECT_URI
import com.ajidres.myapplication.data.api.model.AccessModel
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query


interface EndPointsAccess {


    @POST("access_token")
    suspend fun access(
        @Query("grant_type") grantType: String = "authorization_code",
        @Query("code") code: String,
        @Query("redirect_uri") redirectUri: String = REDIRECT_URI
    ): Response<AccessModel>


}
