package com.prof18.airalo.countrypackages.domain.repository

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrypackages.domain.model.CountryId
import com.prof18.airalo.countrypackages.domain.model.CountryPackages

internal interface CountryPackagesRepository {
    suspend fun getCountryPackages(countryId: CountryId): DataResult<CountryPackages>
}
