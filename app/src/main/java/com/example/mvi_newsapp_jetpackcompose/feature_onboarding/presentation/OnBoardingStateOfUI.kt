package com.example.mvi_newsapp_jetpackcompose.feature_onboarding.presentation

sealed class OnBoardingStateOfUI {
    data class page(val pageOnUI : Int) : OnBoardingStateOfUI()
    object finished : OnBoardingStateOfUI()
}