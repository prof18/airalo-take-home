package com.prof18.airalo.countrychooser.domain.model

import com.prof18.airalo.core.model.ImageUrl

data class Country(
    val id: String,
    val name: String,
    val flagImageUrl: ImageUrl,
)
