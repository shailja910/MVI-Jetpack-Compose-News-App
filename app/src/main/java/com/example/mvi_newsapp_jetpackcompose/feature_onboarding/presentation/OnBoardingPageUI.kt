package com.example.mvi_newsapp_jetpackcompose.feature_onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvi_newsapp_jetpackcompose.domain.model.OnBoardingPages

@Composable
fun OnBoardingPageUI(obj: OnBoardingPages ) {
    Column(modifier = Modifier) {

        Image(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f),
            painter = painterResource(id = obj.image),
            contentDescription = null
        )

        Text(
            text = stringResource(id = obj.title),
            modifier = Modifier.padding(horizontal = 20.dp),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 40.sp
        )

        Text(
            text = stringResource(id =obj.desc),
            modifier = Modifier.padding(horizontal = 20.dp),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontSize = 20.sp
        )
    }
}
