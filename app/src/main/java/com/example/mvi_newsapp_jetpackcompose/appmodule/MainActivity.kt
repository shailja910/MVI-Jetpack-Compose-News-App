package com.example.mvi_newsapp_jetpackcompose.appmodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvi_newsapp_jetpackcompose.common_presentation.Navgraphs.BottomNavigationScreens
import com.example.mvi_newsapp_jetpackcompose.features.onboarding.presentastion.OnBoardingScreensUI
import com.example.mvi_newsapp_jetpackcompose.features.onboarding.presentastion.OnBoardingViewModel
import com.example.mvi_newsapp_jetpackcompose.ui.theme.MVI_NewsApp_JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            MVI_NewsApp_JetpackComposeTheme {

                //onboarding screen navigation.
                var showOnboarding by remember { mutableStateOf(true) }

                if (showOnboarding) {
                    val viewModel: OnBoardingViewModel = hiltViewModel() // Hilt injects useCase inside ViewModel
                    OnBoardingScreensUI(
                        viewModel = viewModel,
                        onFinish = {
                            showOnboarding = false
                        }
                    )
                }

                else{
                    BottomNavigationScreens()
                }
                }
            }
        }
    }

