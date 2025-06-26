package com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.domain.repositoryinterfaces

import com.example.mvi_newsapp_jetpackcompose.core.model.Article

interface B_BreakingNewsRepo {
    suspend fun getBreakingNews(page:Int, country:String): List<Article>
}