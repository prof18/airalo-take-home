package com.prof18.airalo.countrychooser.data.remote.dto

import com.prof18.airalo.core.dto.ImageDTO
import com.prof18.airalo.core.dto.SeoDTO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// TODO: try with an error
@JsonClass(generateAdapter = true)
internal data class CountryDTO(
    val id: Int,
    val image: ImageDTO,
    val seo: SeoDTO?,
    val slug: String,
    val title: String,
    @Json(name = "package_count") val packageCount: Int,
)
