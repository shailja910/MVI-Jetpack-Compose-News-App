package com.example.mvi_newsapp_jetpackcompose.features.onboarding.presentastion

sealed class OnBoardingStateOfUI {
    data class page(val pageOnUI : Int) : OnBoardingStateOfUI()
    object finished : OnBoardingStateOfUI()
}