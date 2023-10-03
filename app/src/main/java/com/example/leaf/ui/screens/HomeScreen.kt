package com.example.leaf.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.leaf.ui.components.BookSection
import com.example.leaf.ui.events.HomeScreenEvent
import com.example.leaf.ui.viewModels.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val state = viewModel.uiState
    
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(HomeScreenEvent.OnLoadTrendingBooks)
        viewModel.onEvent(HomeScreenEvent.OnLoadClassicBooks("accessible_book"))
        viewModel.onEvent(HomeScreenEvent.OnLoadRomanceBooks("romance"))
    }
    
    LazyColumn(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            BookSection(
                title = "Trending",
                workList = state.trendingBooks,
                onClick = { key ->
                    
                    viewModel.onEvent(HomeScreenEvent.OnLoadWorkDetails(key))
                }
            
            )
        }
        item {
            BookSection(
                title = "Clássicos",
                workList = state.classicBooks,
                onClick = { key ->
                    
                    viewModel.onEvent(HomeScreenEvent.OnLoadWorkDetails(key))
                }
            
            )
        }
        item {
            BookSection(
                title = "Romance",
                workList = state.romanceBooks,
                onClick = { key ->
                    
                    viewModel.onEvent(HomeScreenEvent.OnLoadWorkDetails(key))
                }
            
            )
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//
//    val sampleTrendingWorks = listOf(
//        Work(
//            key = "1",
//            title = "Sample Book 1",
//            editions = 3,
//            publishedYear = 2022,
//            coverUrl = "https://samplecover1.com",
//            authorName = "Author 1",
//            subjects = listOf("Subject A", "Subject B")
//        ),
//        Work(
//            key = "2",
//            title = "Sample Book 2",
//            editions = 2,
//            publishedYear = 2021,
//            coverUrl = "https://samplecover2.com",
//            authorName = "Author 2",
//            subjects = listOf("Subject C", "Subject D")
//        )
//    )
//
//    val sampleUiState = HomeScreenUiState(
//        trendingBooks = flowOf(sampleTrendingWorks),
//        isTrendingBooksLoading = false,
//        isTrendingBooksError = null
//    )
//
//    LeafTheme {
//        Surface {
//            HomeScreen(
//                HomeScreenViewModel(
//                    GetTrendingBooksUseCase(
//                        BookRepo
//                    )
//                )
//            )
//        }
//    }
//}