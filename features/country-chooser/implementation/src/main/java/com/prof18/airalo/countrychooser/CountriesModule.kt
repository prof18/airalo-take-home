package com.prof18.airalo.countrychooser

import com.prof18.airalo.countrychooser.data.remote.CountriesApiService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import retrofit2.Retrofit

@Module
@ComponentScan
class CountriesModule {
    @Factory
    internal fun apiService(retrofit: Retrofit): CountriesApiService {
        return retrofit.create(CountriesApiService::class.java)
    }
}
