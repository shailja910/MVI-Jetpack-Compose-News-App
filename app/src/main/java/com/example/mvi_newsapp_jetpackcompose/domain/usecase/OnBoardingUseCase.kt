package com.example.mvi_newsapp_jetpackcompose.domain.usecase

import com.example.mvi_newsapp_jetpackcompose.domain.model.OnBoardingPages
import com.example.mvi_newsapp_jetpackcompose.data.repository.OnBoardingRepo

class OnBoardingUseCase(val repo : OnBoardingRepo){
        operator fun invoke(): List<OnBoardingPages> {
            // In a real app, data might come from repository or remote
            return  repo.getOnboardingPages()  }
    }
