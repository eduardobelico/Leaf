package com.example.leaf.domain.useCases

import com.example.leaf.core.Resource
import com.example.leaf.domain.model.Work
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

//class GetBooksBySubjectUseCase @Inject constructor(
//    private val repository: BookRepository
//) {
//    operator fun invoke(subject: String): Flow<Resource<List<Work>>> = flow {
//        repository.getBooksBySubject(subject)
//            .map { resource ->
//                if (resource is Resource.Success) {
//                    resource.data ?: emptyList()
//                } else {
//                    emptyList()
//                }
//            }
//    }
//}