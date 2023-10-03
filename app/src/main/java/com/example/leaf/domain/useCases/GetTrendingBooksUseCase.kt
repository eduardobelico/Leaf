package com.example.leaf.domain.useCases

import androidx.paging.PagingData
import com.example.leaf.core.Resource
import com.example.leaf.domain.model.Work
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingBooksUseCase @Inject constructor(
    private val repository: BookRepository
) {
    operator fun invoke(): Flow<PagingData<Work>> {
        return repository.getTrendingBooks()
    }
}