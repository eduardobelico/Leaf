package com.example.leaf.data.mappers

import com.example.leaf.data.remote.model.TrendingWorkDto
import com.example.leaf.data.remote.network.BookSearchServices
import com.example.leaf.domain.model.TrendingWork

fun TrendingWorkDto.toTrendingWork(bookSearchServices: BookSearchServices): TrendingWork {
    
    val coverUrl = "https://covers.openlibrary.org/b/id/${coverId}-L.jpg"
    val authorName = authorName.firstOrNull() ?: ""
    val workDto = bookSearchServices.getWorkDetails(key)
    
    return TrendingWork(
        key = key,
        title = title,
        editions = editions,
        publishedYear = publishedYear,
        coverUrl = coverUrl,
        authorName = authorName,
        subjects = workDto.subjects
    )
    
}