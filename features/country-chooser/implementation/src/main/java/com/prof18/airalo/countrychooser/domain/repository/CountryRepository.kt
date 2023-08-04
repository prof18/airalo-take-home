package com.prof18.airalo.countrychooser.domain.repository

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrychooser.domain.model.Country

internal interface CountryRepository {
    suspend fun getCountries(): DataResult<List<Country>>
}
