package com.example.leaf.di

import com.example.leaf.domain.repository.BookRepository
import com.example.leaf.domain.useCases.GetBooksBySubjectUseCase
import com.example.leaf.domain.useCases.GetTrendingBooksUseCase
import com.example.leaf.domain.useCases.GetWorkDetailsUseCase
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
//    fun providesGetAuthorNameUseCase(
//        repository: BookRepository
//    ): GetAuthorNameUseCase {
//        return GetAuthorNameUseCase(repository)
//    }
//
    @Provides
    fun providesGetTrendingBooksUseCase(
        repository: BookRepository
    ): GetTrendingBooksUseCase {
        return GetTrendingBooksUseCase(repository)
    }
    
    @Provides
    fun providesGetBooksBySubjectUseCase(
        repository: BookRepository
    ): GetBooksBySubjectUseCase {
        return GetBooksBySubjectUseCase(repository)
    }
    
    
    @Provides
    fun providesGetWorkDetailsUseCase(
        repository: BookRepository
    ): GetWorkDetailsUseCase {
        return GetWorkDetailsUseCase(repository)
    }
}