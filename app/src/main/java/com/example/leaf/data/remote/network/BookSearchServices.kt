package com.example.leaf.data.remote.network

import com.example.leaf.data.remote.model.AuthorInfoRequest
import com.example.leaf.data.remote.model.AuthorRequest
import com.example.leaf.data.remote.model.BooksByAuthorRequest
import com.example.leaf.data.remote.model.BookSearchRequest
import com.example.leaf.data.remote.model.SubjectRequest
import com.example.leaf.data.remote.model.WorkDto
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
    
    @GET("authors/{key}/works.json")
    fun searchBooksByAuthor(
        @Path("key") authorKey: String
    ): BooksByAuthorRequest
    
    @GET("subjects/{subject}.json")
    fun searchBooksBySubject(
        @Path("subject") subject: String
    ): SubjectRequest
    
    @GET("/works/{key}.json")
    fun searchWork(
        @Path("key") workKey: String
    ): WorkDto
    
    @GET("authors/{authorKey}.json")
    fun searchAuthorInfo(
        @Path("authorKey") authorKey: String
    ): AuthorInfoRequest
}