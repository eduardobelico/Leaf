package com.example.leaf.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    }
    
    BookSection(trendingWorkList = state.trendingBooks,
        onClick = { key ->
            
            viewModel.onEvent(HomeScreenEvent.OnLoadWorkDetails(key))
        }
    )
}

//@Preview(showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//
//    val sampleTrendingWorks = listOf(
//        TrendingWork(
//            key = "1",
//            title = "Sample Book 1",
//            editions = 3,
//            publishedYear = 2022,
//            coverUrl = "https://samplecover1.com",
//            authorName = "Author 1",
//            subjects = listOf("Subject A", "Subject B")
//        ),
//        TrendingWork(
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
//                    GetTrendingBooks(
//                        BookRepo
//                    )
//                )
//            )
//        }
//    }
//}