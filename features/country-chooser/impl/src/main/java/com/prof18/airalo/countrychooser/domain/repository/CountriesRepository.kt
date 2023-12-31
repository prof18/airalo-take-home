package com.prof18.airalo.countrychooser.domain.repository

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.architecture.mapIfSuccess
import com.prof18.airalo.countrychooser.data.remote.CountriesRemoteDataSource
import com.prof18.airalo.countrychooser.data.remote.CountryType
import com.prof18.airalo.countrychooser.domain.mapper.toCountry
import com.prof18.airalo.countrychooser.domain.model.Country
import org.koin.core.annotation.Factory

@Factory
internal class CountriesRepository(
    private val countriesRemoteDataSource: CountriesRemoteDataSource,
) {
    suspend fun getPopularCountries(): DataResult<List<Country>> =
        countriesRemoteDataSource.getCountries(countryType = CountryType.POPULAR)
            .mapIfSuccess { countries ->
                countries.map { dto ->
                    dto.toCountry()
                }
            }
}
