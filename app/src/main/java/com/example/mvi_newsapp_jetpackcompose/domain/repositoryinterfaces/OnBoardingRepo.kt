package com.example.mvi_newsapp_jetpackcompose.domain.repositoryinterfaces

import com.example.mvi_newsapp_jetpackcompose.domain.model.OnBoardingPages

interface OnBoardingRepo {
    fun getOnboardingPages() : List<OnBoardingPages>
}