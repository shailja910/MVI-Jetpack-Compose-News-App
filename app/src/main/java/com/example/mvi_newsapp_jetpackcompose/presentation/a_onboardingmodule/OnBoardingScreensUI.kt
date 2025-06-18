package com.example.mvi_newsapp_jetpackcompose.presentation.a_onboardingmodule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mvi_jetpackcompose_newsapp.presentation.components.common.Button_Back
import com.example.mvi_jetpackcompose_newsapp.presentation.components.common.Button_Next
import com.example.mvi_jetpackcompose_newsapp.presentation.components.common.PageIndicator
import com.example.mvi_newsapp_jetpackcompose.domain.usecase.OnBoardingUseCase
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreensUI(viewModel : OnBoardingViewModel, useCase:OnBoardingUseCase,onFinish:()->Unit) {

    val onbaordinglist = useCase.invoke()

    //1. for swippable pages and adding each onboarding template to the page ,an object of PagerState
    val pagerState = rememberPagerState(pageCount = { viewModel.total_pages })

    //column consists of onboarding page and page indicator and buttons "previous" and "next"
    Column {

        //2.swipeable pages
        HorizontalPager(pagerState)
        { index ->
            OnBoardingPageUI(obj = onbaordinglist.get(index))
        }

        Spacer(modifier = Modifier.weight(1f))

        //3. page indicator
        Row(
            modifier = Modifier.navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(viewModel.total_pages, pagerState)
        }


        /*4.In jetpack Compose , ButtonState is used to perform some action everytime the button is loaded,clicked.
             It has a function "derivedStateOf() , which is used to perform the changes on buttons everytime there is
             change in the dependency  i.e. pagerState.currentPage in our case. */
        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "next")
                    1 -> listOf("back", "next")
                    2 -> listOf("back", "get started")
                    else -> listOf("", "")

                }
            }
        }

        /*  buttons on onboarding pages , animateScrollToPage() is a suspend fxn so must be called from coroutine.
        * take a row which has 2 buttons aligned and arranged in single line . buttonState.value[0] and value[1]
        * holds the list items label name  for back and next button*/
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val scope = rememberCoroutineScope()
            //back button code
            if (buttonState.value[0].isNotEmpty()) {   // if the value in the 0 index of list is not empty that means it has a back button
                Button_Back(text = buttonState.value[0], onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(page = pagerState.currentPage - 1)  //it is code defined for back click go to previous page
                    }
                })
            }

            //for next button
            Button_Next(text = buttonState.value[1], onClick = {
                scope.launch {
                    if (pagerState.currentPage == (viewModel.total_pages - 1)) {
                        onFinish()

                    } else {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            })
        }
    }
}

