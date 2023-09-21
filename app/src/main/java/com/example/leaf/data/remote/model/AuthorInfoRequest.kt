package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class AuthorInfoRequest(
    @SerializedName("personal_name")
    val authorName: String
)
