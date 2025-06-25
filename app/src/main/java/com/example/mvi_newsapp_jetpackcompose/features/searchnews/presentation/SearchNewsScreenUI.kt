package com.example.mvi_newsapp_jetpackcompose.features.searchnews.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mvi_newsapp_jetpackcompose.features.breakingnews.presentastion.ArticleCardComposable
import com.example.mvi_newsapp_jetpackcompose.features.breakingnews.presentastion.BreakingNewsIntent

@Composable
fun SearchNewsScreenUI(viewModel:SearchNewsViewModel) {

    val searchState = viewModel.searchNewsState.collectAsState().value

    LaunchedEffect(key1=true) {
        viewModel.getIntentsearchNews(SearchNewsIntent.LoadDefaultNews)
    }

    //for search bar
    var query by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
                if (query.length >= 3) { // Trigger search after 3 characters
                    viewModel.getIntentsearchNews (SearchNewsIntent.SearchQuery(query))
                }
            },
            label = { Text("Search news...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        when (searchState) {
            is SearchNewsStateUI.Loading -> {
                CircularProgressIndicator()
            }

            is SearchNewsStateUI.Success -> {
                val listarticle = (searchState as SearchNewsStateUI.Success).list
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(listarticle) { article ->
                            ArticleCardComposable(article)
                        }
                    }
                }

            is SearchNewsStateUI.Error -> {
                val error = (searchState as SearchNewsStateUI.Error).msg
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Error: $error", color = Color.Red)
                }
            }

            else -> Unit
        }
    }
}