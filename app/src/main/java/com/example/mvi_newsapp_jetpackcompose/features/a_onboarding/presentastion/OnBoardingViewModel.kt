package com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.presentastion

import androidx.lifecycle.ViewModel
import com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.domain.usecase.A_OnBoardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(val useCase: A_OnBoardingUseCase) :ViewModel(){

    //mutable state object
    private val _onboardState = MutableStateFlow<OnBoardingStateOfUI>(OnBoardingStateOfUI.page(0))
    var onboardState: MutableStateFlow<OnBoardingStateOfUI> = _onboardState

val total_pages = (useCase.invoke()).size  //tell the size of list

    //in this function match state with intent and update the _onboardstate object
    fun getIntentAndUpdateStateUI(intent : OnboardingIntent) {
        val currentPage = _onboardState.value
        when(currentPage) {
            is OnBoardingStateOfUI.page ->
            {
                when (intent) {

                    OnboardingIntent.next -> {
                        if (currentPage.pageOnUI < total_pages - 1)
                            _onboardState.value = OnBoardingStateOfUI.page(currentPage.pageOnUI + 1)
                        else
                            _onboardState.value = OnBoardingStateOfUI.finished
                    }


                    OnboardingIntent.previous -> {
                        if(currentPage.pageOnUI > 0)
                            _onboardState.value= OnBoardingStateOfUI.page(currentPage.pageOnUI - 1)
                    }


                    OnboardingIntent.finish -> {
                        _onboardState.value = OnBoardingStateOfUI.finished
                    }
                }
            }
            else -> Unit
        }
    }
}
