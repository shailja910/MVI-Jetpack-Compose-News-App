package com.example.mvi_newsapp_jetpackcompose.features.c_searchnews.domain.repointerface

import com.example.mvi_newsapp_jetpackcompose.core.model.Article

interface SearchNewsRepository {
    suspend fun getNews() : List<Article>
    suspend fun getSearchedNews(q:String) : List<Article>
}