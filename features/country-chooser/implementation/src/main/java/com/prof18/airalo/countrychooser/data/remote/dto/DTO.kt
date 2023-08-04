package com.prof18.airalo.countrychooser.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class DTO(
    @Json(name = "foo") val foo: String,
)
