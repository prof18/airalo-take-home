package com.prof18.airalo.countrychooser.domain.usecases

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.coroutines.DispatcherProvider
import com.prof18.airalo.countrychooser.domain.model.Country
import com.prof18.airalo.countrychooser.domain.repository.CountryRepository
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Factory

@Factory
internal class CountriesUseCase(
    private val homeCountryRepository: CountryRepository,
    private val dispatcherProvider: DispatcherProvider,
) {
    suspend fun getCountries(): DataResult<List<Country>> =
        withContext(dispatcherProvider.io()) {
            return@withContext homeCountryRepository.getCountries()
        }
}
