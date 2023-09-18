package com.example.leaf.data.mappers

import com.example.leaf.data.remote.model.VolumeDto
import com.example.leaf.domain.model.Volume

fun VolumeDto.toVolume(): Volume {
    return Volume(
        id = id,
        link = link,
        title = volumeInfo.title,
        description = volumeInfo.description,
        authors = volumeInfo.authors,
        publisher = volumeInfo.publisher,
        publisherDate = volumeInfo.publisherDate,
        pageCount = volumeInfo.pageCount,
        smallThumbnail = volumeInfo.imageLinks?.smallThumbnail,
        thumbnail = volumeInfo.imageLinks?.thumbnail
    
    )
}