package com.example.leaf.data.remote.network

import com.example.leaf.data.remote.model.SubjectRequest
import com.example.leaf.data.remote.model.TrendingBooksRequest
import com.example.leaf.data.remote.model.WorkDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookSearchServices {
    
    @GET("/trending/daily.json")
    suspend fun getTrendingBooks(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): TrendingBooksRequest
    
    @GET("/subjects/{subject}.json")
    suspend fun searchBooksBySubject(
        @Path("subject") subject: String
    ): SubjectRequest

//    @GET("search.json")
//    fun searchBooks(
//        @Query("q") query: String
//    ): BookSearchRequest
//
//    @GET("authors.json")
//    fun searchAuthor(
//        @Query("q") query: String
//    ): AuthorRequest
//
//    @GET("authors/{key}/works.json")
//    fun searchBooksByAuthor(
//        @Path("key") authorKey: String
//    ): BooksByAuthorRequest
//
    
    
    @GET("{key}.json")
    suspend fun getWorkDetails(
        @Path("key") workKey: String
    ): WorkDetailsDto
    
//    https://openlibrary.org/works/OL45804W.json

//    @GET("authors/{authorKey}.json")
//    fun searchAuthorInfo(
//        @Path("authorKey") authorKey: String
//    ): AuthorInfoRequest
}