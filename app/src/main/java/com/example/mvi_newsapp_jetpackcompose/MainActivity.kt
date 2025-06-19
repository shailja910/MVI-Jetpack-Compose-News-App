package com.example.mvi_newsapp_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.mvi_newsapp_jetpackcompose.data.repository_impl.onboardingrepo.OnBoardingRepoImpl
import com.example.mvi_newsapp_jetpackcompose.domain.usecase.OnBoardingUseCase
import com.example.mvi_newsapp_jetpackcompose.presentation.Navgraphs.B_NavigationScreens
import com.example.mvi_newsapp_jetpackcompose.feature_onboarding.presentation.OnBoardingScreensUI
import com.example.mvi_newsapp_jetpackcompose.feature_onboarding.presentation.OnBoardingViewModel
import com.example.mvi_newsapp_jetpackcompose.ui.theme.MVI_NewsApp_JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            MVI_NewsApp_JetpackComposeTheme {

                //onboarding screen navigation.
                var showOnboarding by remember { mutableStateOf(true) }

                val useCase = remember { OnBoardingUseCase(OnBoardingRepoImpl()) }
                val viewModel = remember { OnBoardingViewModel(useCase) }

                if (showOnboarding) {
                    OnBoardingScreensUI(
                        viewModel = viewModel,
                        useCase = useCase,
                        onFinish = {
                            showOnboarding = false
                        }
                    )
                }

                else{
                    B_NavigationScreens()
                }
                }
            }
        }
    }

