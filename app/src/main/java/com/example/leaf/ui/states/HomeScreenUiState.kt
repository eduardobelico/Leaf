package com.example.leaf.ui.states

import androidx.paging.PagingData
import com.example.leaf.domain.model.Work
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HomeScreenUiState(
    val trendingBooks: Flow<PagingData<Work>> = flowOf(PagingData.empty()),
    val isTrendingBooksLoading: Boolean = false,
    val isTrendingBooksError: String? = null,
    
    val classicBooks: List<Work> = emptyList(),
    val isClassicBooksLoading: Boolean = false,
    val isClassicBooksError: String? = null,
    
    val romanceBooks: List<Work> = emptyList(),
    val isRomanceBooksLoading: Boolean = false,
    val isRomanceBooksError: String? = null,
    
    val thrillerBooks: List<Work> = emptyList(),
    val isThrillerBooksLoading: Boolean = false,
    val isThrillerBooksError: String? = null,
    
    val fantasyBooks: List<Work> = emptyList(),
    val isFantasyBooksLoading: Boolean = false,
    val isFantasyBooksError: String? = null,
    
    val childrenBooks: List<Work> = emptyList(),
    val isChildrenBooksLoading: Boolean = false,
    val isChildrenBooksError: String? = null,
    
    val subject: List<String> = emptyList()
)


