package com.prof18.airalo.countrychooser.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// TODO: try with an error
@JsonClass(generateAdapter = true)
data class CountryDTO(
    val id: Int,
    val image: ImageDTO,
    val seo: SeoDTO?,
    val slug: String,
    val title: String,
    @Json(name = "package_count")
    val packageCount: Int,
) {

    @JsonClass(generateAdapter = true)
    data class ImageDTO(
        val height: Int,
        val width: Int,
        val url: String,
    )

    @JsonClass(generateAdapter = true)
    data class SeoDTO(
        val description: String?,
        val keywords: String?,
        val title: String?,
    )
}
