package com.example.leaf.data.remote.network

import com.example.leaf.data.remote.model.VolumeDto
import com.example.leaf.data.remote.model.VolumeRequest
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookServices {
    
    @GET("volumes")
    suspend fun getVolumeList(
        @Query("q") query: String
    ): VolumeRequest
    
    @GET("volumes/{volumeId}")
    fun getVolume(
        @Path("volumeId") volumeId: String
    ): VolumeDto
}