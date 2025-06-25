package com.example.mvi_newsapp_jetpackcompose.features.searchnews.domain.usecase

import com.example.mvi_newsapp_jetpackcompose.core.model.Article
import com.example.mvi_newsapp_jetpackcompose.features.searchnews.domain.repointerface.SearchNewsRepository
import javax.inject.Inject

class SearchNewsUseCase @Inject constructor(val repo: SearchNewsRepository) {
    suspend fun getDefaultNews(): List<Article> = repo.getNews()
    suspend fun searchNews(query: String): List<Article> = repo.getSearchedNews(query)
}