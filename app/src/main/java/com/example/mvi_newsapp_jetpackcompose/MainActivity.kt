package com.example.mvi_newsapp_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mvi_newsapp_jetpackcompose.data.repository.OnBoardingRepoImpl
import com.example.mvi_newsapp_jetpackcompose.domain.usecase.OnBoardingUseCase
import com.example.mvi_newsapp_jetpackcompose.presentation.a_onboardingmodule.OnBoardingScreensUI
import com.example.mvi_newsapp_jetpackcompose.presentation.a_onboardingmodule.OnBoardingViewModel
import com.example.mvi_newsapp_jetpackcompose.ui.theme.MVI_NewsApp_JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            MVI_NewsApp_JetpackComposeTheme {
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
                }
            }
        }
    }

