package com.prof18.airalo.countrychooser

import com.prof18.airalo.countrychooser.data.remote.ApiService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import retrofit2.Retrofit

@Module
@ComponentScan
class HomeModule {

    @Factory
    internal fun apiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
