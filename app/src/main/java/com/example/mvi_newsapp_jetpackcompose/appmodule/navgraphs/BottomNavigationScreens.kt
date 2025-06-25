package com.example.mvi_newsapp_jetpackcompose.common_presentation.Navgraphs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.mvi_newsapp_jetpackcompose.features.breakingnews.presentastion.BreakingNewsScreen
import com.example.mvi_newsapp_jetpackcompose.features.breakingnews.presentastion.BreakingNewsViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvi_newsapp_jetpackcompose.features.searchnews.presentation.SearchNewsScreenUI
import com.example.mvi_newsapp_jetpackcompose.features.searchnews.presentation.SearchNewsViewModel


//bottom navigation code
@Composable
fun BottomNavigationScreens()
{
    //val viewModel: BreakingNewsViewModel = hiltView
    var selectedTab by rememberSaveable{ mutableStateOf("breaking") }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                    label = { Text("Breaking") },
                    selected = selectedTab == "breaking",
                    onClick = { selectedTab = "breaking" }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Search, contentDescription = null) },
                    label = { Text("Search") },
                    selected = selectedTab == "search",
                    onClick = { selectedTab = "search" }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    label = { Text("Saved") },
                    selected = selectedTab == "saved",
                    onClick = { selectedTab = "saved" }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            val viewModel: BreakingNewsViewModel = hiltViewModel()

            val viewModelsearch: SearchNewsViewModel = hiltViewModel()
            when (selectedTab) {
                "breaking" -> BreakingNewsScreen(viewModel)
                "search" -> SearchNewsScreenUI(viewModelsearch)
            }
        }
    }
}