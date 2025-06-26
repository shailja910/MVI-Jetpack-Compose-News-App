package com.example.mvi_newsapp_jetpackcompose.features.b_breakingnews.domain.usecase

import com.example.mvi_newsapp_jetpackcompose.core.model.Article
import com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.domain.repositoryinterfaces.B_BreakingNewsRepo
import javax.inject.Inject

class B_BreakingNewsUseCase @Inject constructor(val repo: B_BreakingNewsRepo){
    suspend operator fun invoke(): List<Article>
    {
        return repo.getBreakingNews(1,"us")
    }
}