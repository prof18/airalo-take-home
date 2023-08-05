package com.prof18.airalo.countrychooser.presentation.state

import com.prof18.airalo.core.model.ImageUrl

internal sealed interface CountriesState {
    data object Loading : CountriesState

    data class Error(
        val content: String,
        val retryButtonText: String,
        val onRetryClick: () -> Unit,
    ) : CountriesState

    data class Content(
        val headerTitle: String,
        val countryItems: List<CountryItem>,
    ) : CountriesState {
        data class CountryItem(
            val id: CountryId,
            val name: String,
            val flagImageUrl: ImageUrl,
        ) {
            @JvmInline
            value class CountryId(val value: String)
        }
    }
}
