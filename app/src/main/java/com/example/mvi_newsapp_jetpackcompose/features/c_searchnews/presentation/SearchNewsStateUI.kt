package com.example.mvi_newsapp_jetpackcompose.features.c_searchnews.presentation

import com.example.mvi_newsapp_jetpackcompose.core.model.Article

sealed class SearchNewsStateUI {
    object Idle : SearchNewsStateUI()
    object Loading : SearchNewsStateUI()
    data class Success(val list: List<Article> ): SearchNewsStateUI()
    data class Error(val msg: String) : SearchNewsStateUI()
}