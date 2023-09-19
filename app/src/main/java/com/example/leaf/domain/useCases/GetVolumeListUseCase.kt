package com.example.leaf.domain.useCases

import com.example.leaf.core.Resource
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow

class GetVolumeListUseCase(
    private val repository: BookRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<Volume>>> {
        return repository.getBooksList(query)
    }
}