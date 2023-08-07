package com.prof18.airalo.core.net

import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.annotation.Factory

@Factory
class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request()
            .newBuilder()
            .header("Accept", "application/json")
            /*
                For this sample, the language is always the same.
                In a real scenario, the user's locale should be injected
             */
            .header("Accept-Language", "en")
            .build()

        return chain.proceed(newRequest)
    }
}
