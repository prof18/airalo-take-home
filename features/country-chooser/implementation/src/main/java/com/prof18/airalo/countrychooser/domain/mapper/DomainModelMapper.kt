package com.prof18.airalo.countrychooser.domain.mapper

import com.prof18.airalo.core.model.ImageUrl
import com.prof18.airalo.countrychooser.data.remote.dto.CountryDTO
import com.prof18.airalo.countrychooser.domain.model.Country

internal fun CountryDTO.toCountry(): Country =
    Country(
        id = this.slug,
        name = this.title,
        flagImageUrl = ImageUrl(
            url = this.image.url,
        ),
    )
