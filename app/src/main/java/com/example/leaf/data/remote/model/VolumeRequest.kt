package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class VolumeRequest(
    @SerializedName("items")
    val volumeList: List<VolumeDto>?
)
