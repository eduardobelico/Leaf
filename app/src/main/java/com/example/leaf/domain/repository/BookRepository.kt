package com.example.leaf.domain.repository

import com.example.leaf.core.Resource
import com.example.leaf.domain.model.Work
import com.example.leaf.domain.model.WorkDetails
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    
    //    fun getBooksList(query: String): Flow<Resource<List<Book>>>
//    fun getAuthorsList(query: String): Flow<Resource<List<Author>>>
//    fun getBooksByAuthor(authorKey: String): Flow<Resource<List<WorkDetails>>>
//    fun getAuthorName(authorKey: String): Flow<Resource<String>>
    fun getWorkDetails(workKey: String): Flow<Resource<WorkDetails>>
    fun getBooksBySubject(subject: String): Flow<Resource<List<Work>>>
    fun getTrendingBooks(): Flow<Resource<List<Work>>>
}