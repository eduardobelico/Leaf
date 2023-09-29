package com.example.leaf.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leaf.core.Resource
import com.example.leaf.domain.useCases.GetTrendingBooks
import com.example.leaf.domain.useCases.GetWorkUseCase
import com.example.leaf.ui.events.HomeScreenEvent
import com.example.leaf.ui.states.HomeScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getTrendingBookSearchUseCase: GetTrendingBooks,
    private val getWorkUseCase: GetWorkUseCase
) : ViewModel() {

//    private val _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(
//        HomeScreenUiState()
//    )
//    val uiState get() = _uiState.asStateFlow()
    
    var uiState by mutableStateOf(HomeScreenUiState())
        private set
    
    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            HomeScreenEvent.OnLoadTrendingBooks -> {
                viewModelScope.launch {
                    getTrendingBookSearchUseCase().collectLatest { result ->
                        when (result) {
                            is Resource.Error -> {
                                uiState = uiState.copy(
                                    isTrendingBooksError = result.message
                                )
                            }
                            
                            is Resource.Loading -> {
                                uiState = uiState.copy(
                                    isTrendingBooksLoading = true
                                )
                            }
                            
                            is Resource.Success -> {
                                uiState = uiState.copy(
                                    trendingBooks = result.data ?: emptyList()
                                )
                            }
                        }
                    }
                }
            }
            
            is HomeScreenEvent.OnLoadWorkDetails -> {
                viewModelScope.launch {
                    getWorkUseCase(event.key).collectLatest { result ->
                        when (result) {
                            is Resource.Success -> {
                                uiState = uiState.copy(
                                    subject = result.data?.subjects ?: emptyList()
                                )
                            }
                            
                            else -> {
                                uiState = uiState.copy(
                                    subject = emptyList()
                                )
                            }
                        }
                    }
                }
            }
        }
    }

//    init {
//        _uiState.update { currentState ->
//            currentState.copy(
//                onSearchChange = {
//                    _uiState.value = _uiState.value.copy(
//                        searchText = it,
//                        searchedBooks = searchedBooks()
//                    )
//                }
//            )
//        }
//    }
//
//    private fun searchedBooks(text: String): List<Book> {
//        return if (text.isNotBlank()) {
//            repository.getBooksList()
//        } else {
//            emptyList()
//        }
//    }
}