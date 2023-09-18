package com.example.leaf.data.remote.model

data class VolumeInfoDto(
    val title: String,
    val description: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publisherDate: String?,
    val pageCount: Int?,
    val imageLinks: ImageLinksDto?
)
