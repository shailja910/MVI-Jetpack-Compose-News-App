package com.example.mvi_newsapp_jetpackcompose.features.a_onboarding.presentastion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvi_jetpackcompose_newsapp.presentation.components.common.Button_Back
import com.example.mvi_jetpackcompose_newsapp.presentation.components.common.Button_Next
import com.example.mvi_jetpackcompose_newsapp.presentation.components.common.PageIndicator

@Composable
fun OnBoardingScreensUI(viewModel: OnBoardingViewModel = hiltViewModel(), // Hilt injects the VM here
                        onFinish: () -> Unit
) {

    //state from viewmodel
    val stateOfUI = viewModel.onboardState.collectAsState().value

    //list of onborading pages
    val onboardingList = viewModel.onboardingList


    //remember pager state
    val pagerState = rememberPagerState(
        initialPage = (stateOfUI as? OnBoardingStateOfUI.PageOnUI)?.pageIndex ?: 0,
        pageCount = { viewModel.totalPages }
    )

    //remember coroutine scope
    val coroutineScope = rememberCoroutineScope()

    // Detect if onboarding is finished
    if (stateOfUI is OnBoardingStateOfUI.Complete) {
        onFinish()
        return
    }


        //column consists of onboarding page and page indicator and buttons "previous" and "next"
        Column {
            //2.swipeable pages
            HorizontalPager(pagerState)
            { index ->
                OnBoardingPageUI(obj = onboardingList.get(index))
            }

            Spacer(modifier = Modifier.weight(1f))

            //3. page indicator
            Row(
                modifier = Modifier.navigationBarsPadding(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PageIndicator(viewModel.totalPages, pagerState)
            }

        //4. button naming
            val currentPage = (stateOfUI as? OnBoardingStateOfUI.PageOnUI)?.pageIndex ?: 0
            val buttonLabels = when (currentPage) {
                0 -> listOf("", "Next")
                viewModel.totalPages - 1 -> listOf("Back", "Get Started")
                else -> listOf("Back", "Next")
            }

            //5. show button as "next" and "back" button
        Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (buttonLabels[0].isNotEmpty()) {
                    Button_Back(text = buttonLabels[0]) {
                        viewModel.getIntent_Onboarding(OnboardingIntent.Previous)
                    }
                }

                Button_Next(text = buttonLabels[1]) {
                    if (currentPage == viewModel.totalPages - 1) {
                        viewModel.getIntent_Onboarding(OnboardingIntent.Finish)
                    } else {
                        viewModel.getIntent_Onboarding(OnboardingIntent.Next)
                    }
                }
            }
        }
}
