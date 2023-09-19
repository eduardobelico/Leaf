package com.example.leaf.ui.states

import com.example.leaf.domain.model.Book

data class SearchedScreenUiState(
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {},
    val searchedBooks: List<Book> = emptyList()
) {

}
