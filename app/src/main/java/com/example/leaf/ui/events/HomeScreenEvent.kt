package com.example.leaf.ui.events

sealed class HomeScreenEvent {
    object OnLoadTrendingBooks : HomeScreenEvent()
    data class OnLoadClassicBooks(val subject: String): HomeScreenEvent()
    data class OnLoadRomanceBooks(val subject: String): HomeScreenEvent()
    data class OnLoadWorkDetails(val key: String) : HomeScreenEvent()
}

