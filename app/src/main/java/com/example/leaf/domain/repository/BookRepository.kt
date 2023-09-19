package com.example.leaf.domain.repository

import com.example.leaf.core.Resource
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    
    fun getVolumeList(query: String): Flow<Resource<List<Volume>>>
}