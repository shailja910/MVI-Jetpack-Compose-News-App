package com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.presentastion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.domain.usecase.A_OnBoardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(useCase: A_OnBoardingUseCase
) : ViewModel() {

    private val _onboardState =
        MutableStateFlow<OnBoardingStateOfUI>(OnBoardingStateOfUI.PageOnUI(0))
    val onboardState: MutableStateFlow<OnBoardingStateOfUI> = _onboardState


    val onboardingList = useCase.invoke()  //on boarding pages list
    val totalPages: Int = onboardingList.size

    fun getIntent_Onboarding(intent: OnboardingIntent) {
        viewModelScope.launch {
            val current = _onboardState.value

            if (current is OnBoardingStateOfUI.PageOnUI) {
                val index = current.pageIndex
                when (intent) {
                    OnboardingIntent.Next -> {
                        if (index < totalPages - 1)
                            _onboardState.value = OnBoardingStateOfUI.PageOnUI(index + 1)
                        else
                            _onboardState.value = OnBoardingStateOfUI.Complete
                    }

                    OnboardingIntent.Previous -> {
                        if (index> 0)
                        _onboardState.value = OnBoardingStateOfUI.PageOnUI(index - 1)
                    }

                    OnboardingIntent.Finish -> {
                        _onboardState.value = OnBoardingStateOfUI.Complete
                    }
                }
            }
        }
    }
}

