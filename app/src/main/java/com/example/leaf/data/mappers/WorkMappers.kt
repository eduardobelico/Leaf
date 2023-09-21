package com.example.leaf.data.mappers

import com.example.leaf.data.remote.model.WorkDto
import com.example.leaf.domain.model.Work
import com.example.leaf.domain.repository.BookRepository
import kotlinx.coroutines.flow.firstOrNull

fun WorkDto.toWork(
//    authorName: String
): Work {
    
    val firstCoverCode = covers.firstOrNull() ?: 0
    val coverUrl = "https://covers.openlibrary.org/b/id/${firstCoverCode}-L.jpg"
    
    return Work(
        title = title,
        coverUrl = coverUrl,
        description = description,
        subjects = subjects
//        authorName = authorName
    )
}