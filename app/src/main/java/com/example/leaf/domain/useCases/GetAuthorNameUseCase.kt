package com.example.leaf.domain.useCases

import com.example.leaf.core.Resource
import com.example.leaf.domain.model.Book
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class GetAuthorNameUseCase(
    private val repository: BookRepository
) {
    operator fun invoke(authorKey: String): Flow<Resource<String>> {
        return repository.getAuthorName(authorKey)
    }
}