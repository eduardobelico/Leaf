package com.example.leaf.ui.states

import com.example.leaf.domain.model.Book

data class HomeScreenUiState(
        val sections: Map<String, List<Book>> = emptyMap()
) {

}
