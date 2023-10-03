package com.example.leaf.domain.useCases

//
//class GetBooksByAuthorUseCase @Inject constructor(
//    private val repository: BookRepository
//) {
//    operator fun invoke(authorKey: String): Flow<Resource<List<WorkDetails>>> = flow {
//        repository.getBooksBySubject(authorKey)
//            .map { resource ->
//                if (resource is Resource.Success) {
//                    resource.data ?: emptyList()
//                } else {
//                    emptyList()
//                }
//            }
//    }
//}
