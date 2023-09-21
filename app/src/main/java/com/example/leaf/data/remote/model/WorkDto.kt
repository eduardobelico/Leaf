package com.example.leaf.data.remote.model

data class WorkDto(
    val title: String,
    val key: String,
    val authors: List<AuthorDataDto>,
    val covers: List<Int>,
    val description: String,
    val subjects: List<String>
)