package com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.presentastion

sealed class OnboardingIntent {
    object Previous : OnboardingIntent()
    object Next : OnboardingIntent()
    object Finish : OnboardingIntent()
}
