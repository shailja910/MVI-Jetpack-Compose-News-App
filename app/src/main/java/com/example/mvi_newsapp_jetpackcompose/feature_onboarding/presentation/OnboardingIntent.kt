package com.example.mvi_newsapp_jetpackcompose.feature_onboarding.presentation

sealed class OnboardingIntent {
    object previous : OnboardingIntent()
    object next : OnboardingIntent()
    object finish : OnboardingIntent()
}
