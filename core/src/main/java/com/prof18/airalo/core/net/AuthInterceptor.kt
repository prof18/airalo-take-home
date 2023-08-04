package com.prof18.airalo.core.net

import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.annotation.Factory

@Factory
class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl = chain.request().url
            .newBuilder()
            // .addQueryParameter("api_key", "<api-key>")
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}
