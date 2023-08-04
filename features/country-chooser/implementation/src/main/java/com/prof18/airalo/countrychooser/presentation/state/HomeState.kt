package com.prof18.airalo.countrychooser.presentation.state

internal sealed interface HomeState {
    data object Loading : HomeState

    data class Error(
        val content: String,
        val buttonText: String,
        val onRetryClick: () -> Unit,
    ) : HomeState

    data class Content(
        val something: String,
    ) : HomeState
}
