package com.example.leaf.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leaf.core.Resource
import com.example.leaf.domain.repository.BookRepository
import com.example.leaf.domain.useCases.BookSearchUseCase
import com.example.leaf.domain.useCases.GetTrendingBooks
import com.example.leaf.ui.events.HomeScreenEvent
import com.example.leaf.ui.states.HomeScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getTrendingBookSearchUseCase: GetTrendingBooks
) : ViewModel() {
    
    private val _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(
        HomeScreenUiState()
    )
    val uiState get() = _uiState.asStateFlow()
    
    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            HomeScreenEvent.OnLoadTrendingBooks -> {
                viewModelScope.launch {
                    getTrendingBookSearchUseCase().collectLatest { result ->
                        when (result) {
                            is Resource.Error -> {
                                _uiState.value = _uiState.value.copy(
                                    isTrendingBooksError = result.message
                                )
                            }
                            
                            is Resource.Loading -> {
                                _uiState.value = _uiState.value.copy(
                                    isTrendingBooksLoading = true
                                )
                            }
                            
                            is Resource.Success -> {
                                _uiState.value = _uiState.value.copy(
                                trendingBooks = flowOf(result.data ?: emptyList())
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