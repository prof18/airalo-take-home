package com.prof18.airalo.countrypackages

import com.prof18.airalo.countrypackages.data.remote.CountryPackagesApiService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import retrofit2.Retrofit

@Module
@ComponentScan
class CountryPackagesModule {
    @Factory
    internal fun apiService(retrofit: Retrofit): CountryPackagesApiService {
        return retrofit.create(CountryPackagesApiService::class.java)
    }
}
