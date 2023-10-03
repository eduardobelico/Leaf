package com.example.leaf.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.leaf.core.Resource
import com.example.leaf.data.mappers.toWork
import com.example.leaf.data.mappers.toWorkDetails
import com.example.leaf.data.remote.network.BookSearchServices
import com.example.leaf.data.remote.network.TrendingBooksPagingSource
import com.example.leaf.domain.model.Work
import com.example.leaf.domain.model.WorkDetails
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val service: BookSearchServices
) : BookRepository {
//
//    override fun getBooksList(
//        query: String
//    ): Flow<Resource<List<Book>>> = flow {
//        try {
//
//            val response = service.searchBooks(query = query)
//            val booksList = response.bookList.map { bookDto ->
//                bookDto.toBook()
//            }
//            emit(Resource.Success(booksList))
//        } catch (e: Exception) {
//            Log.e(TAG, "Error fetching books", e)
//            emit(Resource.Error("Error fetching books: ${e.message}"))
//        }
//    }
//
//    override fun getAuthorsList(
//        query: String
//    ): Flow<Resource<List<Author>>> = flow {
//        try {
//
//            val response = service.searchAuthor(query = query)
//            val authorList = response.authorList.map { authorDto ->
//                authorDto.toAuthor()
//            }
//            emit(Resource.Success(authorList))
//        } catch (e: Exception) {
//            Log.e(TAG, "Error fetching author", e)
//            emit(Resource.Error("Error fetching author: ${e.message}"))
//        }
//    }
//
//    override fun getBooksByAuthor(
//        authorKey: String
//    ): Flow<Resource<List<WorkDetails>>> = flow {
//        try {
//            val workList = mutableListOf<WorkDto>()
//
//            val response = service.searchBooksByAuthor(authorKey = authorKey)
//            val keysList = response.booksByAuthor.map { listedWorksDto ->
//                listedWorksDto.key
//            }
//            for (workKey in keysList) {
//                val work = service.getWorkDetails(workKey)
//                workList.add(work)
//            }
//            emit(Resource.Success(workList.map {
//                it.toWork()
//            }))
//        } catch (e: Exception) {
//            Log.e(TAG, "Error fetching author", e)
//            emit(Resource.Error("Error fetching author: ${e.message}"))
//        }
//    }
//

//
//    override fun getAuthorName(
//        authorKey: String
//    ): Flow<Resource<String>> = flow {
//        try {
//
//            val response = service.searchAuthorInfo(authorKey)
//            val authorName = response.authorName
//            emit(Resource.Success(authorName))
//        } catch (e: Exception) {
//            Log.e(TAG, "Error fetching author", e)
//            emit(Resource.Error("Error fetching author: ${e.message}"))
//        }
//    }
    
    override fun getWorkDetails(
        workKey: String
    ): Flow<Resource<WorkDetails>> = flow {
        try {
            val response = service.getWorkDetails(workKey = workKey)
            val work = response.toWorkDetails()
            emit(Resource.Success(work))
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching works", e)
            emit(Resource.Error("Error fetching works: ${e.message}"))
        }
    }
    
    override fun getTrendingBooks(): Flow<PagingData<Work>> {
        val pagingSourceFactory = { TrendingBooksPagingSource(services = service) }
        val pager = Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = pagingSourceFactory
        ).flow
        return pager.map { pagingData ->
            pagingData.map { it.toWork(service)
            }
        }
        
    }
    
    override fun getBooksBySubject(
        subject: String
    ): Flow<Resource<List<Work>>> = flow {
        try {
            val booksBySubject = service.searchBooksBySubject(subject = subject)
            val workList = booksBySubject.works.map {
                it.toWork(service)
            }
            emit(Resource.Success(workList))
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching works", e)
            emit(Resource.Error("Error fetching works: ${e.message}"))
        }
    }
    
}
