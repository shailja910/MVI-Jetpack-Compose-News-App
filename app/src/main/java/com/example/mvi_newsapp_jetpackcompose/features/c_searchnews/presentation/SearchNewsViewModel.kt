package com.example.mvi_newsapp_jetpackcompose.features.c_searchnews.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvi_newsapp_jetpackcompose.features.c_searchnews.domain.usecase.SearchNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchNewsViewModel @Inject constructor(val useCase: SearchNewsUseCase):ViewModel() {

    private val _searchNewsState = MutableStateFlow<SearchNewsStateUI>(SearchNewsStateUI.Idle)
    val searchNewsState = _searchNewsState

    fun getIntentsearchNews(intent: SearchNewsIntent) {
        viewModelScope.launch {

            when (intent) {
                is SearchNewsIntent.LoadDefaultNews -> {
                    _searchNewsState.value = SearchNewsStateUI.Loading
                    try {
                        val newsList = useCase.getDefaultNews() // This should return a non-empty list
                        _searchNewsState.value = SearchNewsStateUI.Success(newsList)
                    } catch (e: Exception) {
                        _searchNewsState.value = SearchNewsStateUI.Error(e.message ?: "Unknown Error")
                    }
                }

                is SearchNewsIntent.SearchQuery -> {
                    _searchNewsState.value = SearchNewsStateUI.Loading
                    try {
                        val listOfNews = useCase.searchNews(intent.q)
                        _searchNewsState.value = SearchNewsStateUI.Success(listOfNews)
                    } catch (e: Exception) {
                        _searchNewsState.value = SearchNewsStateUI.Error(e.message ?: "unknown error")
                    }
                }
            }
        }
    }
}