package com.example.leaf.core

import android.content.Context
import coil.request.ImageRequest

fun loadBookCover(context: Context, url: String) {
    val request = ImageRequest.Builder(context)
        .data(url)
        .crossfade(true)
        .build()
}
