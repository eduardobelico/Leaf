package com.example.leaf.ui.states

import com.example.leaf.domain.model.ListedWork
import com.example.leaf.domain.model.TrendingWork

data class HomeScreenUiState(
    val trendingBooks: List<TrendingWork> = emptyList(),
    val booksBySubject: List<ListedWork> = emptyList(),
    val isBookListLoading: Boolean = false,
    val isBookListError: String? = null,
    val subject: List<String> = emptyList()
)


