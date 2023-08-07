package com.prof18.airalo.countrychooser.fixtures

import com.prof18.airalo.core.dto.ImageDTO
import com.prof18.airalo.countrychooser.data.remote.dto.CountryDTO

internal val defaultCountryDTO = CountryDTO(
    id = 42,
    image = ImageDTO(
        height = 42,
        width = 42,
        url = "https://www.imageUrl.com",
    ),
    seo = null,
    slug = "italy",
    title = "Italy",
    packageCount = 42,
)
