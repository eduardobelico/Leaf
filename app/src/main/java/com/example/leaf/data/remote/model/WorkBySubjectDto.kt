package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class WorkBySubjectDto(
    val key: String,
    val title: String,
    @SerializedName("edition_count")
    val editions: Int,
    @SerializedName("first_publish_year")
    val publishedYear: Int,
    @SerializedName("cover_id")
    val coverId: Int,
    val authors: List<AuthorInfoDto>,
    val subject: List<String>
)
