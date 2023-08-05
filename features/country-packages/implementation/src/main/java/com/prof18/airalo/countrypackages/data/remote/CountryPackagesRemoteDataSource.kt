package com.prof18.airalo.countrypackages.data.remote

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrypackages.domain.model.CountryId
import com.prof18.airalo.countrypackages.data.remote.dto.CountryPackagesDTO

internal interface CountryPackagesRemoteDataSource {
    suspend fun getCountryPackages(
        countryId: CountryId,
    ): DataResult<CountryPackagesDTO>
}
