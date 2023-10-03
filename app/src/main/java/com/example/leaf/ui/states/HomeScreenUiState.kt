package com.example.leaf.ui.states

import com.example.leaf.domain.model.Work

data class HomeScreenUiState(
    val trendingBooks: List<Work> = emptyList(),
    val isTrendingBooksLoading: Boolean = false,
    val isTrendingBooksError: String? = null,
    
    val classicBooks: List<Work> = emptyList(),
    val isClassicBooksLoading: Boolean = false,
    val isClassicBooksError: String? = null,
    
    val romanceBooks: List<Work> = emptyList(),
    val isRomanceBooksLoading: Boolean = false,
    val isRomanceBooksError: String? = null,
    
    val subject: List<String> = emptyList()
)


