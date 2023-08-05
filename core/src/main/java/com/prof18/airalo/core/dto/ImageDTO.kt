package com.prof18.airalo.core.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageDTO(
    val height: Int,
    val width: Int,
    val url: String,
)
