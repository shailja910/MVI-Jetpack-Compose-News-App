package com.example.mvi_newsapp_jetpackcompose.core.domain.repository

import com.example.mvi_newsapp_jetpackcompose.features.onboarding.data.A_OnBoardingRepoImpl
import com.example.mvi_newsapp_jetpackcompose.features.breakingnews.data.B_BreakingNewsRepoImpl
import com.example.mvi_newsapp_jetpackcompose.features.onboarding.domain.repositoryinterfaces.A_OnBoardingRepo
import com.example.mvi_newsapp_jetpackcompose.features.onboarding.domain.repositoryinterfaces.B_BreakingNewsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoandRepoImplBinding {

    @Binds
    @Singleton
    abstract fun bindOnBoardingRepository(
        onboardingRepositoryImpl: A_OnBoardingRepoImpl
    ): A_OnBoardingRepo


    @Binds
    @Singleton
    abstract fun bindBreakingNewsRepository(
        breakingnewsRepositoryImpl: B_BreakingNewsRepoImpl
    ): B_BreakingNewsRepo
}