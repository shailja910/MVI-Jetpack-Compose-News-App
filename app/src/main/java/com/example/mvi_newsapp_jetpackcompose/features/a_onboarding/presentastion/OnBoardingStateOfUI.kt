package com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.presentastion

sealed class OnBoardingStateOfUI {
    data class PageOnUI(val pageIndex : Int) : OnBoardingStateOfUI()
    object Complete : OnBoardingStateOfUI()
}