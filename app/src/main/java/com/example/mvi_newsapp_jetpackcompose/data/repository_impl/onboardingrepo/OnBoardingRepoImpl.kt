package com.example.mvi_newsapp_jetpackcompose.data.repository_impl.onboardingrepo


import com.example.mvi_newsapp_jetpackcompose.domain.model.OnBoardingPages
import com.example.mvi_newsapp_jetpackcompose.R
import com.example.mvi_newsapp_jetpackcompose.domain.repositoryinterfaces.OnBoardingRepo

class OnBoardingRepoImpl : OnBoardingRepo {
    override fun getOnboardingPages(): List<OnBoardingPages> {
        val listOfOnboarding = listOf(
            OnBoardingPages(R.string.OBTitle1,R.string.OBDesc1,R.drawable.ob_image1),
            OnBoardingPages(R.string.OBTitle2,R.string.OBDesc2,R.drawable.ob_image2),
            OnBoardingPages(R.string.OBTitle3,R.string.OBDesc3,R.drawable.ob_image3)
        )
        return listOfOnboarding

    }
}