package com.example.leaf.data.remote.model

import com.google.gson.annotations.SerializedName

data class WorkRequest(
    @SerializedName("entries")
    val booksByAuthor: List<WorkDto>
)
