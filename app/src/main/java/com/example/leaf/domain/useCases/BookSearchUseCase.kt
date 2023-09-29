package com.example.leaf.domain.useCases

import com.example.leaf.core.Resource
import com.example.leaf.domain.model.Book
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//class BookSearchUseCase @Inject constructor(
//    private val repository: BookRepository
//) {
//    operator fun invoke(query: String): Flow<Resource<List<Book>>> {
//        return repository.getBooksList(query)
//    }
//}