package com.example.leaf.di

import com.example.leaf.domain.repository.BookRepository
import com.example.leaf.domain.useCases.GetBookListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    
    @Provides
    fun providesGetBookListUseCase(
        repository: BookRepository
    ): GetBookListUseCase {
        return GetBookListUseCase(repository)
    }
}