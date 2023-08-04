package com.prof18.airalo.countrychooser.data.remote

import com.prof18.airalo.countrychooser.data.remote.dto.DTO
import retrofit2.http.GET

internal interface ApiService {

    @GET("url")
    suspend fun getSomething(): List<DTO>
}
