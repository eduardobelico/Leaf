package com.example.leaf.domain.repository

import com.example.leaf.core.Resource
import com.example.leaf.domain.model.Author
import com.example.leaf.domain.model.Book
import com.example.leaf.domain.model.TrendingWork
import com.example.leaf.domain.model.Work
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    
//    fun getBooksList(query: String): Flow<Resource<List<Book>>>
//    fun getAuthorsList(query: String): Flow<Resource<List<Author>>>
//    fun getBooksByAuthor(authorKey: String): Flow<Resource<List<Work>>>
//    fun getBooksBySubject(subject: String): Flow<Resource<List<Work>>>
//    fun getAuthorName(authorKey: String): Flow<Resource<String>>
    fun getWork(workKey: String): Flow<Resource<Work>>
    fun getTrendingBooks(): Flow<Resource<List<TrendingWork>>>
}