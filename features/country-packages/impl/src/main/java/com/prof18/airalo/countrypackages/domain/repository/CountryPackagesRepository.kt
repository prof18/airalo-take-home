package com.prof18.airalo.countrypackages.domain.repository

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.architecture.mapIfSuccess
import com.prof18.airalo.countrypackages.data.remote.CountryPackagesRemoteDataSource
import com.prof18.airalo.countrypackages.domain.mapper.toCountryPackages
import com.prof18.airalo.countrypackages.domain.model.CountryId
import com.prof18.airalo.countrypackages.domain.model.CountryPackages
import org.koin.core.annotation.Factory

@Factory
internal class CountryPackagesRepository(
    private val countryPackagesRemoteDataSource: CountryPackagesRemoteDataSource,
) {
    suspend fun getCountryPackages(countryId: CountryId): DataResult<CountryPackages> =
        countryPackagesRemoteDataSource.getCountryPackages(countryId)
            .mapIfSuccess { dto ->
                dto.toCountryPackages()
            }
}
