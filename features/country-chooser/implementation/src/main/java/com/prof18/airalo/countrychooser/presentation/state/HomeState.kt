package com.prof18.airalo.countrychooser.presentation.state

internal sealed interface HomeState {
    data object Loading : HomeState

    data class Error(
        val content: String,
        val buttonText: String,
        val onRetryClick: () -> Unit,
    ) : HomeState

    data class Content(
        val headerTitle: String,
        val countryItems: List<CountryItem>,
    ) : HomeState {
        data class CountryItem(
            val id: CountryId,
            val name: String,
            val flagImageUrl: String,
        ) {
            @JvmInline
            value class CountryId(val value: String)
        }
    }
}
