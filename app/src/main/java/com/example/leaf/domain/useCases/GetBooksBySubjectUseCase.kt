package com.example.leaf.domain.useCases

import com.example.leaf.core.Resource
import com.example.leaf.domain.model.ListedWork
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBooksBySubjectUseCase @Inject constructor(
    private val repository: BookRepository
) {
    operator fun invoke(subject: String): Flow<Resource<List<ListedWork>>> {
        return repository.getBooksBySubject(subject)
    }
}