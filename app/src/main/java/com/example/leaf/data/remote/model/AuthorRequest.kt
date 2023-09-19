package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class AuthorRequest(
    val start: Int,
    @SerializedName("numFound")
    val authorsFound: Int,
    @SerializedName("docs")
    val authorList: List<AuthorDto>
)
