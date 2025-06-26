package com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.domain.usecase

import com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.domain.model.OnBoardingPages
import com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.domain.repositoryinterfaces.A_OnBoardingRepo
import javax.inject.Inject

class A_OnBoardingUseCase @Inject constructor(val repo : A_OnBoardingRepo){
        operator fun invoke(): List<OnBoardingPages> {
            // In a real app, data might come from repository or remote
            return  repo.getOnboardingPages()  }
    }
