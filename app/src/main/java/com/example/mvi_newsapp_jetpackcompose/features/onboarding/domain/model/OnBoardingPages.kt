package com.example.mvi_newsapp_jetpackcompose.features.onboarding.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnBoardingPages(
       @StringRes val title : Int,
        @StringRes val desc:Int,
        @DrawableRes val image:Int
    )