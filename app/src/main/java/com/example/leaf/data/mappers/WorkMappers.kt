package com.example.leaf.data.mappers

import com.example.leaf.data.remote.model.WorkDto
import com.example.leaf.data.remote.model.WorkRequest
import com.example.leaf.domain.model.Work

fun WorkDto.toWork(): Work {
    
    val firstCoverCode = covers.firstOrNull() ?: 0
    val coverUrl = "https://covers.openlibrary.org/b/id/${firstCoverCode}-L.jpg"
    
    return Work(
        title = title,
        coverUrl = coverUrl
    )
}