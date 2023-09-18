package com.example.leaf.domain.model

import com.example.leaf.data.remote.model.ImageLinksDto

class Volume(
    val id: String,
    val link: String,
    val title: String,
    val description: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publisherDate: String?,
    val pageCount: Int?,
    val smallThumbnail: String?,
    val thumbnail: String?
)