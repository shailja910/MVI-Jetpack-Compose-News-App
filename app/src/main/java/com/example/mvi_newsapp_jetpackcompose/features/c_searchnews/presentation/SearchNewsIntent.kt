package com.example.mvi_newsapp_jetpackcompose.features.c_searchnews.presentation

sealed class SearchNewsIntent {
    object LoadDefaultNews : SearchNewsIntent()
    data class SearchQuery(val q:String) : SearchNewsIntent()
}