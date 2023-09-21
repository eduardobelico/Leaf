package com.example.leaf.domain.useCases

import com.example.leaf.core.Resource
import com.example.leaf.domain.model.Work
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWorkUseCase @Inject constructor(
    private val repository: BookRepository
) {
    operator fun invoke(workKey: String): Flow<Resource<Work>> = repository.getWork(workKey)
}