package com.prof18.airalo.countrypackages.domain.usecases

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.coroutines.DispatcherProvider
import com.prof18.airalo.countrypackages.domain.model.CountryId
import com.prof18.airalo.countrypackages.domain.model.CountryPackages
import com.prof18.airalo.countrypackages.domain.repository.CountryPackagesRepository
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Factory

@Factory
internal class CountryPackagesUseCase(
    private val homeCountryPackagesRepository: CountryPackagesRepository,
    private val dispatcherProvider: DispatcherProvider,
) {
    suspend fun getCountryPackages(countryId: CountryId): DataResult<CountryPackages> =
        withContext(dispatcherProvider.io()) {
            return@withContext homeCountryPackagesRepository.getCountryPackages(countryId)
        }
}
