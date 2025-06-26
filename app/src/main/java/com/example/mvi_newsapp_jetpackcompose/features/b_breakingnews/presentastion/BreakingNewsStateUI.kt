package com.example.mvi_newsapp_jetpackcompose.features.b_breakingnews.presentastion

import com.example.mvi_newsapp_jetpackcompose.core.model.Article

sealed class BreakingNewsStateUI {
    object Idle : BreakingNewsStateUI()
    object Loading : BreakingNewsStateUI()
    data class Success(val list: List<Article> ): BreakingNewsStateUI()
    data class Error(val msg: String) : BreakingNewsStateUI()
}