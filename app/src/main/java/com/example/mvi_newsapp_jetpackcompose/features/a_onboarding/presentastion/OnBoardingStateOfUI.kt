package com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.presentastion

sealed class OnBoardingStateOfUI {
    data class page(val pageOnUI : Int) : OnBoardingStateOfUI()
    object finished : OnBoardingStateOfUI()
}