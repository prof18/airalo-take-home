package com.prof18.airalo.core.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SeoDTO(
    val description: String?,
    val keywords: String?,
    val title: String?,
)
