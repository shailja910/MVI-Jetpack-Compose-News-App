package com.example.mvi_newsapp_jetpackcompose.domain.usecase

import com.example.mvi_newsapp_jetpackcompose.domain.repositoryinterfaces.OnBoardingRepo
import com.example.mvi_newsapp_jetpackcompose.domain.model.OnBoardingPages

class OnBoardingUseCase(val repo : OnBoardingRepo){
        operator fun invoke(): List<OnBoardingPages> {
            // In a real app, data might come from repository or remote
            return  repo.getOnboardingPages()  }
    }
