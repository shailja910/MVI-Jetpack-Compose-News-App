package com.example.mvi_newsapp_jetpackcompose.features.onboarding.presentastion

sealed class OnboardingIntent {
    object previous : OnboardingIntent()
    object next : OnboardingIntent()
    object finish : OnboardingIntent()
}
