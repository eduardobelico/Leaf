package com.example.leaf.domain.model

data class Work(
    val key: String,
    val title: String,
    val editions: Int,
    val publishedYear: Int,
    val coverUrl: String,
    val authorName: String
) {
    fun empty(): Work {
        return Work(
            key = "",
            title = "Harry Potter",
            editions = 3,
            publishedYear = 2015,
            coverUrl = "",
            authorName = "J.K.Rowling"
        )
    }
}
