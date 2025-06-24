package com.example.mvi_newsapp_jetpackcompose.features.onboarding.domain.repositoryinterfaces

import com.example.mvi_newsapp_jetpackcompose.features.onboarding.domain.model.OnBoardingPages

interface A_OnBoardingRepo {
    fun getOnboardingPages() : List<OnBoardingPages>
}