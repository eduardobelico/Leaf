package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class AuthorDto(
    val key: String,
    val name: String,
    @SerializedName("birth_date")
    val birthDate: Int,
    @SerializedName("top_work")
    val topWork: String,
    @SerializedName("work_count")
    val workCount: Int
)
