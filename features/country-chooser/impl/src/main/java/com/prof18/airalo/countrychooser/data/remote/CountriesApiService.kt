package com.prof18.airalo.countrychooser.data.remote

import com.prof18.airalo.countrychooser.data.remote.dto.CountryDTO
import retrofit2.http.GET
import retrofit2.http.Query

internal interface CountriesApiService {
    @GET("countries")
    suspend fun getCountries(
        @Query("type") type: String?,
    ): List<CountryDTO>
}
