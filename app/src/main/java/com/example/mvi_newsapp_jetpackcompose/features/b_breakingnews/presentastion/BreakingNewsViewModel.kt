package com.example.mvi_newsapp_jetpackcompose.features.b_breakingnews.presentastion

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvi_newsapp_jetpackcompose.features.b_breakingnews.domain.usecase.B_BreakingNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreakingNewsViewModel @Inject constructor(val useCase: B_BreakingNewsUseCase) : ViewModel() {


    //set Mutable state
    private val _breakingNewsState = MutableStateFlow<BreakingNewsStateUI>(BreakingNewsStateUI.Idle)
            val breakingNewsState: MutableStateFlow<BreakingNewsStateUI> = _breakingNewsState


    //define a function to update state as per intent
    fun getIntent_BreakingNews(intent: BreakingNewsIntent){
    viewModelScope.launch{
    when(intent)
    {
        is BreakingNewsIntent.fetchNews -> {
            _breakingNewsState.value = BreakingNewsStateUI.Loading

            try
                {
                    val listOfNews = useCase.invoke()
                    Log.d("BreakingNewsUseCase", "Articles count: ${listOfNews.size}")
                    _breakingNewsState.value = BreakingNewsStateUI.Success(listOfNews)
                  }
            catch(e: Exception)
            {
                _breakingNewsState.value = BreakingNewsStateUI.Error(e.toString())
            }
        }
    } } }
}