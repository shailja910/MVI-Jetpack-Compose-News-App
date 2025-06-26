package com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.domain.repositoryinterfaces

import com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.domain.model.OnBoardingPages

interface A_OnBoardingRepo {
    fun getOnboardingPages() : List<OnBoardingPages>
}