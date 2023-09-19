package com.example.leaf.domain.model

data class Book(
    val title: String,
    val authorName: List<String>,
    val firstPublishYear: Int,
    val subject: List<String>,
    val key: String,
    val coverUrl: String,
    val editionCount: Int
)
