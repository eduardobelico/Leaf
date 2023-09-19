package com.example.leaf.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.leaf.core.Resource
import com.example.leaf.data.mappers.toBook
import com.example.leaf.data.remote.network.BookSearchServices
import com.example.leaf.domain.model.Book
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BookRepositoryImpl(
    private val service: BookSearchServices
) : BookRepository {
    
    override fun getBooksList(
        query: String
    ): Flow<Resource<List<Book>>> = flow {
        try {
            emit(Resource.Loading())
            
            val response = service.searchBooks(query = query)
            val booksList = response.bookList.map { bookDto ->
                bookDto.toBook()
            }
            emit(Resource.Success(booksList))
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching books", e)
            emit(Resource.Error("Error fetching books: ${e.message}"))
        }
    }
}
