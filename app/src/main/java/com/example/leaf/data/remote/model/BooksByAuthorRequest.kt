package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class BooksByAuthorRequest(
    @SerializedName("entries")
    val booksByAuthor: List<ListedWorksDto>
)