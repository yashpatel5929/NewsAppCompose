package com.example.newsapp.data.remote

import com.example.newsapp.data.remote.dtos.NewList.TopStoriesDtos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top/")
    suspend fun getTopStories(
        @Query("api_token") token : String,
        @Query("limit") limit:Int
    ) : Response<TopStoriesDtos>
}