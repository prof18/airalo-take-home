package com.prof18.airalo.countrychooser.data.remote

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrychooser.data.remote.dto.CountryDTO
import org.koin.core.annotation.Factory

@Factory
internal class CountriesRemoteDataSourceImpl(
    private val countriesApiService: CountriesApiService,
) : CountriesRemoteDataSource {

    // Suppress because a generic mapping is done
    @Suppress("TooGenericExceptionCaught")
    override suspend fun getCountries(countryType: CountryType?): DataResult<List<CountryDTO>> {
        return try {
            DataResult.Success(countriesApiService.getCountries(type = countryType?.value))
        } catch (throwable: Throwable) {
            /*
                For this sample, the exception is send without any mapping.
                In a real situation the exception could be mapped to a domain model
                to represent specific errors (e.g. a custom API error code).
             */
            DataResult.Error(throwable)
        }
    }
}
