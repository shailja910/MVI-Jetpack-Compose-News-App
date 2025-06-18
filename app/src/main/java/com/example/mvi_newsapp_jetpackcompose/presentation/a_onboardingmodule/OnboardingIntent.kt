package com.example.mvi_newsapp_jetpackcompose.presentation.a_onboardingmodule

sealed class OnboardingIntent {
    object previous : OnboardingIntent()
    object next : OnboardingIntent()
    object finish : OnboardingIntent()
}
