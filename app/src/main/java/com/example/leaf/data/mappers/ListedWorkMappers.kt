package com.example.leaf.data.mappers

import com.example.leaf.data.remote.model.ListedWorkDto
import com.example.leaf.data.remote.network.BookSearchServices
import com.example.leaf.domain.model.ListedWork

fun ListedWorkDto.toListedWork(bookSearchServices: BookSearchServices): ListedWork {
    
    val coverUrl = "https://covers.openlibrary.org/b/id/${coverId}-L.jpg"
    val author = authors.firstOrNull()?.name ?: "Autor Desconhecido"
    
    return ListedWork(
        key = key,
        title = title,
        editions = editions,
        publishedYear = publishedYear,
        coverUrl = coverUrl,
        author = author,
        subjects = subject
    )
    
}