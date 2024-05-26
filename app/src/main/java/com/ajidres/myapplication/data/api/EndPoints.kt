package com.ajidres.myapplication.data.api

import com.ajidres.myapplication.data.api.model.FeedModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface EndPoints {


    @GET("top")
    suspend fun feed(@Query("limit") limit: Int = 5): Response<FeedModel>


}
