package com.example.leaf.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.leaf.core.Resource
import com.example.leaf.data.mappers.toAuthor
import com.example.leaf.data.mappers.toBook
import com.example.leaf.data.remote.network.BookSearchServices
import com.example.leaf.domain.model.Author
import com.example.leaf.domain.model.Book
import com.example.leaf.domain.model.Work
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
    
    override fun getAuthorsList(
        query: String
    ): Flow<Resource<List<Author>>> = flow {
        try {
            emit(Resource.Loading())
            
            val response = service.searchAuthor(query = query)
            val authorList = response.authorList.map { authorDto ->
                authorDto.toAuthor()
            }
            emit(Resource.Success(authorList))
            } catch (e: Exception) {
            Log.e(TAG, "Error fetching author", e)
            emit(Resource.Error("Error fetching author: ${e.message}"))
        }
    }
    
    override fun getBooksByAuthor(
    authorKey: String
    ): Flow<Resource<List<String>>> = flow {
        try {
            emit(Resource.Loading())
            
            val response = service.searchBooksByAuthor(authorKey = authorKey)
            val workKeys = response.booksByAuthor.map { listedWorksDto ->
                listedWorksDto.key
            }
            emit(Resource.Success(workKeys))
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching author", e)
            emit(Resource.Error("Error fetching author: ${e.message}"))
        }
    }
    
    override fun getBooksBySubject(
        subject: String
    ): Flow<Resource<List<String>>> = flow {
        try {
            emit(Resource.Loading())
            
            val response = service.searchBooksBySubject(subject = subject)
            val workKeys = response.works.map { listedWorksDto ->
            listedWorksDto.key
            }
            emit(Resource.Success(workKeys))
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching author", e)
            emit(Resource.Error("Error fetching author: ${e.message}"))
        }
    }
    
    override fun getAuthorName(
        authorKey: String
    ): Flow<Resource<String>> = flow {
        try {
            emit(Resource.Loading())
            
            val response = service.searchAuthorInfo(authorKey)
            val authorName = response.authorName
            emit(Resource.Success(authorName))
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching author", e)
            emit(Resource.Error("Error fetching author: ${e.message}"))
        }
    }
    
    
}
