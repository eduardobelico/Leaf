package com.example.leaf.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.leaf.domain.model.TrendingWork
import com.example.leaf.ui.events.HomeScreenEvent
import com.example.leaf.ui.states.HomeScreenUiState
import com.example.leaf.ui.theme.LeafTheme
import com.example.leaf.ui.viewModels.HomeScreenViewModel
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState(),
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(HomeScreenEvent.OnLoadTrendingBooks)
    }
    
    Column {
    
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    
    val sampleTrendingWorks = listOf(
        TrendingWork(
            key = "1",
            title = "Sample Book 1",
            editions = 3,
            publishedYear = 2022,
            coverUrl = "https://samplecover1.com",
            authorName = "Author 1",
            subjects = listOf("Subject A", "Subject B")
        ),
        TrendingWork(
            key = "2",
            title = "Sample Book 2",
            editions = 2,
            publishedYear = 2021,
            coverUrl = "https://samplecover2.com",
            authorName = "Author 2",
            subjects = listOf("Subject C", "Subject D")
        )
    )
    
    val sampleUiState = HomeScreenUiState(
        trendingBooks = flowOf(sampleTrendingWorks),
        isTrendingBooksLoading = false,
        isTrendingBooksError = null
    )
    
    LeafTheme {
        Surface {
            HomeScreen(state = sampleUiState)
        }
    }
}