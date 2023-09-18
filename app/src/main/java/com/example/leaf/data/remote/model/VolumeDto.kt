package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class VolumeDto(
    val id: String,
    @SerializedName("selfLink")
    val link: String,
    val volumeInfo: VolumeInfoDto
)
