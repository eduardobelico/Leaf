package com.example.leaf.domain.useCases

import com.example.leaf.core.Resource
import com.example.leaf.domain.model.Volume
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

class GetVolumeListUseCase(
    private val repository: BookRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<Volume>>> {
        return repository.getVolumeList(query)
    }
}