package com.example.leaf.data.remote.network

import com.example.leaf.data.remote.model.AuthorRequest
import com.example.leaf.data.remote.model.WorkRequest
import com.example.leaf.data.remote.model.BookSearchRequest
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookSearchServices {
    
    @GET("search.json")
    fun searchBooks(
        @Query("q") query: String
    ): BookSearchRequest
    
    @GET("authors.json")
    fun searchAuthor(
        @Query("q") query: String
    ): AuthorRequest
    
    @GET("subjects/{subject}.json")
    fun searchBooksBySubject(
        @Path("subject") subject: String
    ): BookSearchRequest
    
    @GET("authors/{key}/works/json")
    fun searchBooksByAuthor(
        @Path("key") authorKey: String
    ): WorkRequest
}