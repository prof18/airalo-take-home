package com.prof18.airalo.countrychooser.data.remote

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrychooser.data.remote.dto.CountryDTO

internal interface CountriesRemoteDataSource {
    suspend fun getCountries(
        countryType: CountryType = CountryType.POPULAR,
    ): DataResult<List<CountryDTO>>
}
