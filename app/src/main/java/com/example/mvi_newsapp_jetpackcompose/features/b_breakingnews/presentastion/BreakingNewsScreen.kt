package com.example.mvi_newsapp_jetpackcompose.features.b_breakingnews.presentastion

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BreakingNewsScreen(viewModel: BreakingNewsViewModel,onArticleClick: (String) -> Unit) {

    // Trigger fetch once when screen appears
    LaunchedEffect(Unit) {
        viewModel.getIntent_BreakingNews(BreakingNewsIntent.fetchNews)
    }

    val vmState = viewModel.breakingNewsState.collectAsState().value

    when (vmState) {
        is BreakingNewsStateUI.Loading -> {
            Box(Modifier.fillMaxSize(),Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is BreakingNewsStateUI.Success -> {
            val listOfArticle = (vmState as BreakingNewsStateUI.Success).list
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(listOfArticle) { article ->
                    ArticleCardComposable(article = article, onClick = {
                        article.url?.let { onArticleClick(it) }
                    })
                }
            }
        }


        is BreakingNewsStateUI.Error -> {
            val message = vmState.msg
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text("Error: $message", color = Color.Red)
            }
        }
        else -> Unit
    }
}