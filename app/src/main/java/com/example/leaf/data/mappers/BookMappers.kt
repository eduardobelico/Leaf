package com.example.leaf.data.mappers

import com.example.leaf.data.remote.model.BookDto
import com.example.leaf.domain.model.Book

fun BookDto.toBook(): Book {
    val coverUrl = "https://covers.openlibrary.org/b/id/${coverId}-L.jpg"
    
    return Book(
        title = title,
        authorName = authorName,
        firstPublishYear = firstPublishYear,
        subject = subject,
        key = key,
        coverUrl = coverUrl,
        editionCount = editionCount
    )
}