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
            // TODO: add comment about getting the language from shared prefs
            .header("Accept-Language", "en")
            .build()

        return chain.proceed(newRequest)
    }
}
