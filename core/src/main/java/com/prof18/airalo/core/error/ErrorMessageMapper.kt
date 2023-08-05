package com.prof18.airalo.core.error

import com.prof18.airalo.core.R

/**
 * Generates the String Resource ID for the error message and the text button from an [NetworkError]
 */
fun NetworkError.getErrorLocalizedMessage(): LocalizedErrorMessage {
    return when (this) {
        is NetworkError.Network -> {
            LocalizedErrorMessage(
                messageStringResID = R.string.unknown_network_error_message,
                buttonTextResId = R.string.retry_button,
            )
        }
        is NetworkError.NotFound -> {
            LocalizedErrorMessage(
                messageStringResID = R.string.resource_not_found_error_message,
                buttonTextResId = R.string.retry_button,
            )
        }
        is NetworkError.NotAuthorized -> {
            LocalizedErrorMessage(
                messageStringResID = R.string.not_allowed_error_message,
                buttonTextResId = R.string.retry_button,
            )
        }
        is NetworkError.ServiceNotWorking, is NetworkError.ServiceUnavailable -> {
            LocalizedErrorMessage(
                messageStringResID = R.string.server_unreachable_error_message,
                buttonTextResId = R.string.retry_button,
            )
        }
        is NetworkError.ApiError -> {
            LocalizedErrorMessage(
                messageStringResID = R.string.unknown_network_error_message,
                buttonTextResId = R.string.retry_button,
            )
        }
    }
}
