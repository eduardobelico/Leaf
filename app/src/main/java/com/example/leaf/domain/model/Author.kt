package com.example.leaf.domain.model

import com.google.gson.annotations.SerializedName

data class Author(
    val key: String,
    val name: String,
    val birthDate: Int,
    val topWork: String,
    val workCount: Int
)
