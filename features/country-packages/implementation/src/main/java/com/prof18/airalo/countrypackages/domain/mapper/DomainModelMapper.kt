package com.prof18.airalo.countrypackages.domain.mapper

import com.prof18.airalo.core.model.ImageUrl
import com.prof18.airalo.countrypackages.data.remote.dto.CountryPackagesDTO
import com.prof18.airalo.countrypackages.domain.model.ColorGradient
import com.prof18.airalo.countrypackages.domain.model.CountryPackages
import com.prof18.airalo.countrypackages.domain.model.CountryPackages.NetworkOperator
import com.prof18.airalo.countrypackages.domain.model.CountryPackages.Package

internal fun CountryPackagesDTO.toCountryPackages(): CountryPackages =
    CountryPackages(
        id = this.slug,
        countryName = this.title,
        packages = this.packages.map { packageDTO ->
            Package(
                id = packageDTO.slug,
                networkDataAmountLabel = packageDTO.data,
                validityLabel = packageDTO.validity,
                price = packageDTO.price,
                colorGradient = ColorGradient(
                    startColor = packageDTO.operator.gradientStart,
                    endColor = packageDTO.operator.gradientEnd,
                ),
                networkOperator = NetworkOperator(
                    id = packageDTO.operator.id,
                    name = packageDTO.operator.title,
                    imageUrl = ImageUrl(
                        url = packageDTO.operator.image.url,
                    ),
                ),
            )
        },
    )
