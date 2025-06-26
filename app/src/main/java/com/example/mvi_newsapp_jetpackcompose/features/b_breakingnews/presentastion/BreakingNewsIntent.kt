package com.example.mvi_newsapp_jetpackcompose.features.b_breakingnews.presentastion

sealed class BreakingNewsIntent {
    object fetchNews: BreakingNewsIntent()
}