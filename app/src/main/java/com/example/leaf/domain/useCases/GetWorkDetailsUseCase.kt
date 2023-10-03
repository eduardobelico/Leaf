package com.example.leaf.domain.useCases

import com.example.leaf.core.Resource
import com.example.leaf.domain.model.WorkDetails
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWorkDetailsUseCase @Inject constructor(
    private val repository: BookRepository
) {
    operator fun invoke(workKey: String): Flow<Resource<WorkDetails>> = repository.getWorkDetails(workKey)
}