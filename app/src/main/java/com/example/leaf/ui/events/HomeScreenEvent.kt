package com.example.leaf.ui.events

sealed class HomeScreenEvent {
    object OnLoadTrendingBooks : HomeScreenEvent()
    data class OnLoadWorkDetails(val key: String) : HomeScreenEvent()
}
