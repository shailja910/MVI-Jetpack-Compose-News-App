package com.example.mvi_newsapp_jetpackcompose.data.repository

import com.example.mvi_newsapp_jetpackcompose.domain.model.OnBoardingPages

interface OnBoardingRepo {
    fun getOnboardingPages() : List<OnBoardingPages>
}