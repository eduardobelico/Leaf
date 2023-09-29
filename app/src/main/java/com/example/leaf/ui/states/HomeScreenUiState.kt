package com.example.leaf.ui.states

import com.example.leaf.domain.model.TrendingWork
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HomeScreenUiState(
    val trendingBooks: List<TrendingWork> = emptyList(),
    val isTrendingBooksLoading: Boolean = false,
    val isTrendingBooksError: String? = null,
    val subject: List<String> = emptyList()
)


