package com.example.leaf.domain.model

import com.google.gson.annotations.SerializedName

data class TrendingWork(
    val key: String,
    val title: String,
    val editions: Int,
    val publishedYear: Int,
    val coverUrl: String,
    val authorName: String,
    val subjects: List<String>
)
