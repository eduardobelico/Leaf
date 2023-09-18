package com.example.leaf.data.repository

import android.util.Log
import com.example.leaf.core.Resource
import com.example.leaf.data.mappers.toVolume
import com.example.leaf.data.remote.network.BookServices
import com.example.leaf.domain.model.Volume
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BookRepositoryImpl(
    private val service: BookServices
) : BookRepository {
    
    override fun getVolumeFromQuery(
        query: String
    ): Flow<Resource<List<Volume>>> = flow {
        try {
            emit(Resource.Loading())
            val response = service.getVolumeList(query = query)
            val volumeListDto = response.volumeList
            val volumeList = volumeListDto?.map { volumeDto ->
                volumeDto.toVolume()
            }
            emit(Resource.Success(volumeList))
        } catch (e: Exception) {
            Log.e("BookRepository", "$e")
            emit(Resource.Error("Procure por um outro livro!"))
    
    }
}