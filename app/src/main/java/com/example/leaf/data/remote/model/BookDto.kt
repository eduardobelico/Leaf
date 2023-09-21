package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class BookDto(
    val title: String,
    @SerializedName("author_name")
    val authorName: List<String>,
    @SerializedName("author_key")
    val authorKey: List<String>,
    @SerializedName("")
    val firstPublishYear: Int,
    val subject: List<String>,
    val key: String,
    @SerializedName("cover_i")
    val coverId: Int,
    @SerializedName("edition_count")
    val editionCount: Int
)
