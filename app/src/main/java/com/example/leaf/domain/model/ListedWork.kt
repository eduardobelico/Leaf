package com.example.leaf.domain.model

data class ListedWork(
    val key: String,
    val title: String,
    val editions: Int,
    val publishedYear: Int,
    val coverUrl: String,
    val author: String,
    val subjects: List<String>
)
