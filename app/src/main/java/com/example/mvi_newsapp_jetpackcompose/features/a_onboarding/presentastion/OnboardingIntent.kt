package com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.presentastion

sealed class OnboardingIntent {
    object previous : OnboardingIntent()
    object next : OnboardingIntent()
    object finish : OnboardingIntent()
}
