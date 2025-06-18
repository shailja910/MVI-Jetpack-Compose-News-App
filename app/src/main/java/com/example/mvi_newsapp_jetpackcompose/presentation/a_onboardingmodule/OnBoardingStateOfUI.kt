package com.example.mvi_newsapp_jetpackcompose.presentation.a_onboardingmodule

sealed class OnBoardingStateOfUI {
    data class page(val pageOnUI : Int) : OnBoardingStateOfUI()
    object finished : OnBoardingStateOfUI()
}