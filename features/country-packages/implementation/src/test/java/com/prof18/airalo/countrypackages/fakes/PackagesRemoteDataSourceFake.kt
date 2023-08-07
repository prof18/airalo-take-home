package com.prof18.airalo.countrypackages.fakes

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrypackages.data.remote.CountryPackagesRemoteDataSource
import com.prof18.airalo.countrypackages.data.remote.dto.CountryPackagesDTO
import com.prof18.airalo.countrypackages.domain.model.CountryId

internal object PackagesRemoteDataSourceFake : CountryPackagesRemoteDataSource {

    var packagesDTO: CountryPackagesDTO? = null
    var error: Throwable = Throwable()

    override suspend fun getCountryPackages(countryId: CountryId): DataResult<CountryPackagesDTO> =
        if (packagesDTO != null) {
            DataResult.Success(
                requireNotNull(packagesDTO),
            )
        } else {
            DataResult.Error(error)
        }
}
