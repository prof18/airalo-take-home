package com.prof18.airalo.core.error

sealed class NetworkError(
    cause: Throwable,
) : Throwable(cause) {
    class Network(cause: Throwable) : NetworkError(cause)

    class NotFound(cause: Throwable) : NetworkError(cause)

    class NotAuthorized(cause: Throwable) : NetworkError(cause)

    class ServiceUnavailable(cause: Throwable) : NetworkError(cause)

    class ServiceNotWorking(cause: Throwable) : NetworkError(cause)

    class ApiError(cause: Throwable, errorCode: Int) : NetworkError(cause)
}
