package com.example.mvi_newsapp_jetpackcompose.core.network

import com.example.mvi_newsapp_jetpackcompose.BuildConfig
import com.example.mvi_newsapp_jetpackcompose.core.model.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface C_RetrofitAPI {
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("page") page: Int,
        @Query("country") countryCode: String, // ✅ required
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): ArticleResponse


    @GET("v2/everything")
    suspend fun getSearchedNews(
        @Query("q") query : String,
        @Query("apiKey") apiKey: String= BuildConfig.API_KEY
    ):ArticleResponse
}