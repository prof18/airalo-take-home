package com.prof18.airalo.countrychooser.fakes

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrychooser.data.remote.CountriesRemoteDataSource
import com.prof18.airalo.countrychooser.data.remote.CountryType
import com.prof18.airalo.countrychooser.data.remote.dto.CountryDTO

internal object CountriesRemoteDataSourceFake : CountriesRemoteDataSource {

    var countriesList: List<CountryDTO>? = null
    var error: Throwable = Throwable()

    fun clear() {
        countriesList = null
    }

    override suspend fun getCountries(countryType: CountryType?): DataResult<List<CountryDTO>> =
        if (countriesList != null) {
            DataResult.Success(
                requireNotNull(countriesList),
            )
        } else {
            DataResult.Error(error)
        }
}
