package com.example.mvi_newsapp_jetpackcompose.features.breakingnews.presentastion

sealed class BreakingNewsIntent {
    object fetchNews: BreakingNewsIntent()
}