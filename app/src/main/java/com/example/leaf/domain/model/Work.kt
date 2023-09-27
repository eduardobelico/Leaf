package com.example.leaf.domain.model

data class Work(
    val title: String,
    val coverUrl: String,
    val description: String?,
    val subjects: List<String>,
    var authorName: String = ""
)
