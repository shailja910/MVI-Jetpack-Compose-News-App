package com.example.mvi_jetpackcompose_newsapp.presentation.components.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageIndicator(pageCount:Int, pageState: androidx.compose.foundation.pager.PagerState)
{
    Row(modifier=Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)){
        repeat(pageCount){
            index->
            val color = if(pageState.currentPage==index) Color.Black else Color.Gray
          Box(modifier = Modifier.size(12.dp)
              .background(color, CircleShape)
              )

        }
    }
}
