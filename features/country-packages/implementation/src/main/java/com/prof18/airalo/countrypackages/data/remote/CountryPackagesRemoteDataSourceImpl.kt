package com.prof18.airalo.countrypackages.data.remote

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrypackages.data.remote.dto.CountryPackagesDTO
import com.prof18.airalo.countrypackages.domain.model.CountryId
import org.koin.core.annotation.Factory

@Factory
internal class CountryPackagesRemoteDataSourceImpl(
    private val countryPackagesApiService: CountryPackagesApiService,
) : CountryPackagesRemoteDataSource {

    // Suppress because a generic mapping is done
    @Suppress("TooGenericExceptionCaught")
    override suspend fun getCountryPackages(countryId: CountryId): DataResult<CountryPackagesDTO> {
        return try {
            DataResult.Success(
                countryPackagesApiService.getCountryPackages(
                    countryId = countryId.value,
                ),
            )
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
