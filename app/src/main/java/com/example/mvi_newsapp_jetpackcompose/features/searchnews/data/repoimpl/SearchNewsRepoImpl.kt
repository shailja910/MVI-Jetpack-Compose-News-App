package com.example.mvi_newsapp_jetpackcompose.features.searchnews.data.repoimpl

import com.example.mvi_newsapp_jetpackcompose.core.model.Article
import com.example.mvi_newsapp_jetpackcompose.core.network.C_RetrofitAPI
import com.example.mvi_newsapp_jetpackcompose.features.searchnews.domain.repointerface.SearchNewsRepository
import javax.inject.Inject

class SearchNewsRepoImpl @Inject constructor(val api : C_RetrofitAPI) : SearchNewsRepository {
    override suspend fun getNews() : List<Article>
    {
        val articlelist= api.getBreakingNews(1,"ca")
        return articlelist.articles
    }

    override suspend fun getSearchedNews(q: String): List<Article> {
        val response= api.getSearchedNews(q)
        return response.articles
    }
}