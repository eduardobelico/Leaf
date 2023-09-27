package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class TrendingWorkDto(
    val key: String,
    val title: String,
    @SerializedName("edition_count")
    val editions: Int,
    @SerializedName("first_publish_year")
    val publishedYear: Int,
    @SerializedName("cover_i")
    val coverId: Int,
    @SerializedName("author_name")
    val authorName: List<String>,
    val subjects: List<String>? = null
)
