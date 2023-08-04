package com.prof18.airalo.countrychooser.fakes

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrychooser.data.remote.CountriesRemoteDataSource
import com.prof18.airalo.countrychooser.data.remote.dto.CountryDTO

internal class FakeCountriesRemoteDataSource : CountriesRemoteDataSource {
    override suspend fun getCountries(): DataResult<List<CountryDTO>> {
        TODO("Not yet implemented")
    }
}
