package com.example.leaf.domain.repository

import com.example.leaf.core.Resource
import com.example.leaf.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    
    fun getBooksList(query: String): Flow<Resource<List<Book>>>
}