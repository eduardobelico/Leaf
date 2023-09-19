package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class BookRequest(
    val start: Int,
    @SerializedName("num_found")
    val booksFound: Int,
    val docs: List<BookDto>
)
