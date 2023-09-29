package com.example.leaf.ui.events

sealed class HomeScreenEvent {
    object OnLoadTrendingBooks : HomeScreenEvent()
    data class OnLoadClassicBooks(val subject: String = "accessible_book"): HomeScreenEvent()
    data class OnLoadWorkDetails(val key: String) : HomeScreenEvent()
}

