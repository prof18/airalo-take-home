package com.prof18.airalo.core.error

import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

fun Throwable.mapToNetworkError(): Throwable {
    return when (this) {
        is IOException -> NetworkError.Network(this)
        is HttpException -> {
            when (code()) {
                // 404
                HttpURLConnection.HTTP_NOT_FOUND -> NetworkError.NotFound(this)

                // 401
                HttpURLConnection.HTTP_UNAUTHORIZED -> NetworkError.NotAuthorized(this)

                // 503
                HttpURLConnection.HTTP_UNAVAILABLE -> NetworkError.ServiceUnavailable(this)

                // 500
                HttpURLConnection.HTTP_INTERNAL_ERROR -> NetworkError.ServiceNotWorking(this)

                else -> {
                    val errorCode = code()
                    val content = response()?.errorBody()?.string()
                    NetworkError.ApiError(
                        cause = this,
                        errorCode = errorCode,
                        errorContent = content,
                    )
                }
            }
        }

        else -> this
    }
}
