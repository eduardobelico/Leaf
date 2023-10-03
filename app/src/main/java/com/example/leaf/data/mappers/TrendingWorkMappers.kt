package com.example.leaf.data.mappers

import com.example.leaf.data.remote.model.TrendingWorkDto
import com.example.leaf.data.remote.network.BookSearchServices
import com.example.leaf.domain.model.Work

fun TrendingWorkDto.toWork(bookSearchServices: BookSearchServices): Work {
    
    val coverUrl = "https://covers.openlibrary.org/b/id/${coverId}-L.jpg"
    val authorName = authorName.firstOrNull() ?: ""
    
    return Work(
        key = key,
        title = title,
        editions = editions,
        publishedYear = publishedYear,
        coverUrl = coverUrl,
        authorName = authorName
    )
}