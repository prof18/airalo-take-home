package com.prof18.airalo.countrypackages.domain.model

import com.prof18.airalo.core.model.ImageUrl

internal data class CountryPackages(
    val id: String,
    val countryName: String,
    val packages: List<Package>,
) {
    data class Package(
        val id: String,
        val networkDataAmountLabel: String,
        val validityLabel: String,
        val price: Double,
        val networkOperator: NetworkOperator,
        val colorGradient: ColorGradient,
    )

    data class NetworkOperator(
        val id: Int,
        val name: String,
        val imageUrl: ImageUrl,
    )
}
