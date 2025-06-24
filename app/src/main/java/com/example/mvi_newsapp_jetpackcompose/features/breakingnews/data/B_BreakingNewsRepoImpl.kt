package com.example.mvi_newsapp_jetpackcompose.features.breakingnews.data

import com.example.mvi_newsapp_jetpackcompose.core.model.Article
import com.example.mvi_newsapp_jetpackcompose.core.network.C_RetrofitAPI
import com.example.mvi_newsapp_jetpackcompose.features.onboarding.domain.repositoryinterfaces.B_BreakingNewsRepo
import javax.inject.Inject

class B_BreakingNewsRepoImpl @Inject constructor(val api: C_RetrofitAPI) : B_BreakingNewsRepo {
    override suspend fun getBreakingNews(page:Int,country:String) : List<Article>
    {
        val articlelist= api.getBreakingNews(page,country)
        return articlelist.articles
    }
}