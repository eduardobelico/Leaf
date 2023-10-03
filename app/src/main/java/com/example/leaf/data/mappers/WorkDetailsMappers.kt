package com.example.leaf.data.mappers

import com.example.leaf.data.remote.model.WorkDetailsDto
import com.example.leaf.domain.model.WorkDetails

fun WorkDetailsDto.toWorkDetails(): WorkDetails {
    
    return WorkDetails(
        description = description,
        subjects = subjects
    )
}