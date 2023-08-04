package com.prof18.airalo.core.error

import com.prof18.airalo.core.R

/**
 * Generates the String Resource ID for the error message and the text button from an [NetworkError]
 */
fun NetworkError.getErrorLocalizedMessage(): ErrorLocalizedMessage {
    return when (this) {
        is NetworkError.Network -> {
            ErrorLocalizedMessage(
                messageStringResID = R.string.unknown_network_error,
                buttonTextResId = R.string.retry_button,
            )
        }
        is NetworkError.NotFound -> {
            ErrorLocalizedMessage(
                messageStringResID = R.string.error_message_not_found,
                buttonTextResId = R.string.retry_button,
            )
        }
        is NetworkError.NotAuthorized -> {
            ErrorLocalizedMessage(
                messageStringResID = R.string.error_message_not_allowed,
                buttonTextResId = R.string.retry_button,
            )
        }
        is NetworkError.ServiceNotWorking, is NetworkError.ServiceUnavailable -> {
            ErrorLocalizedMessage(
                messageStringResID = R.string.server_unreachable,
                buttonTextResId = R.string.retry_button,
            )
        }
        is NetworkError.ApiError -> {
            ErrorLocalizedMessage(
                messageStringResID = R.string.unknown_network_error,
                buttonTextResId = R.string.retry_button,
            )
        }
    }
}
