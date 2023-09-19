package com.example.leaf.data.remote.network

import com.example.leaf.data.remote.model.BookRequest
import retrofit2.http.GET
import retrofit2.http.Query

interface BookSearchServices {
    
    @GET("search.json")
    fun searchBooks(
        @Query("q") query: String
    ): BookRequest
}