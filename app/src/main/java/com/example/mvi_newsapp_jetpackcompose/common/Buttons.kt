package com.example.mvi_jetpackcompose_newsapp.presentation.components.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Button_Back(text:String ,
                     onClick:()->Unit)
{
Button(onClick=onClick,
        colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Red,
                                containerColor = Color.Blue,
                                ),
        shape= RoundedCornerShape(size=6.dp)
    ) {
        Text(text=text)
    }
}

@Composable
fun Button_Next(text:String ,
                     onClick:()->Unit)
{
    Button(onClick=onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Yellow,
            containerColor = Color.Blue,
        ),
        shape= RoundedCornerShape(size=6.dp)
    ) {
        Text(text=text)
    }
}