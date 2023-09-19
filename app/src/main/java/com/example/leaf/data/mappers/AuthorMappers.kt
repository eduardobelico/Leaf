package com.example.leaf.data.mappers

import com.example.leaf.data.remote.model.AuthorDto
import com.example.leaf.domain.model.Author

fun AuthorDto.toAuthor(): Author {
    return Author(
        key = key,
        name = name,
        birthDate = birthDate,
        topWork = topWork,
        workCount = workCount
    )
}