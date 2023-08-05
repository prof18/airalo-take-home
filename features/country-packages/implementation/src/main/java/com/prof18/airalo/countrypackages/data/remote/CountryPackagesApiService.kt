package com.prof18.airalo.countrypackages.data.remote

import com.prof18.airalo.countrypackages.data.remote.dto.CountryPackagesDTO
import retrofit2.http.GET
import retrofit2.http.Path

internal interface CountryPackagesApiService {
    @GET("countries/{countryId}")
    suspend fun getCountryPackages(
        @Path("countryId") countryId: String,
    ): CountryPackagesDTO
}
