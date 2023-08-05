package com.prof18.airalo.countrychooser.data.remote

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.error.mapToNetworkError
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
            // TODO: check error parsing
            DataResult.Error(throwable.mapToNetworkError())
        }
    }
}
