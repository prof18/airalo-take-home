package com.prof18.airalo.countrychooser.domain.repository

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.architecture.mapIfSuccess
import com.prof18.airalo.countrychooser.data.remote.CountriesRemoteDataSource
import com.prof18.airalo.countrychooser.data.remote.CountryType
import com.prof18.airalo.countrychooser.domain.mapper.toCountry
import com.prof18.airalo.countrychooser.domain.model.Country
import org.koin.core.annotation.Factory

@Factory
internal class CountriesRepositoryImpl(
    private val countriesRemoteDataSource: CountriesRemoteDataSource,
) : CountriesRepository {
    override suspend fun getCountries(): DataResult<List<Country>> =
        countriesRemoteDataSource.getCountries(countryType = CountryType.POPULAR)
            .mapIfSuccess {
                it.map { dto ->
                    dto.toCountry()
                }
            }
}
