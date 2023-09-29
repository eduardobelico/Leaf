package com.example.leaf.domain.model

data class TrendingWork(
    val key: String,
    val title: String,
    val editions: Int,
    val publishedYear: Int,
    val coverUrl: String,
    val authorName: String
) {
    fun empty(): TrendingWork {
        return TrendingWork(
            key = "",
            title = "Harry Potter",
            editions = 3,
            publishedYear = 2015,
            coverUrl = "",
            authorName = "J.K.Rowling"
        )
    }
}
