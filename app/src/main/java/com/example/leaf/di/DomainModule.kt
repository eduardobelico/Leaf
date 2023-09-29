package com.example.leaf.di

import com.example.leaf.domain.repository.BookRepository
import com.example.leaf.domain.useCases.GetTrendingBooks
import com.example.leaf.domain.useCases.GetWorkUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    
//    @Provides
//    fun providesGetBookListUseCase(
//        repository: BookRepository
//    ): BookSearchUseCase {
//        return BookSearchUseCase(repository)
//    }
//
//    @Provides
//    fun providesAuthorSearchUseCase(
//        repository: BookRepository
//    ): AuthorSearchUseCase {
//        return AuthorSearchUseCase(repository)
//    }
//
//    @Provides
//    fun providesGetBookByAuthorUseCase(
//        repository: BookRepository
//    ): GetBooksByAuthorUseCase {
//        return GetBooksByAuthorUseCase(repository)
//    }
//
//    @Provides
//    fun providesGetBooksBySubjectUseCase(
//        repository: BookRepository
//    ): GetBooksBySubjectUseCase {
//        return GetBooksBySubjectUseCase(repository)
//    }
//
//    @Provides
//    fun providesGetAuthorNameUseCase(
//        repository: BookRepository
//    ): GetAuthorNameUseCase {
//        return GetAuthorNameUseCase(repository)
//    }
//
    @Provides
    fun providesGetTrendingBooks(
        repository: BookRepository
    ): GetTrendingBooks {
        return  GetTrendingBooks(repository)
    }
    
    @Provides
    fun providesGetWorkDetails(
        repository: BookRepository
    ): GetWorkUseCase {
        return GetWorkUseCase(repository)
    }
}