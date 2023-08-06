package com.prof18.airalo.countrychooser.presentation.components

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.prof18.airalo.core.model.CountryId
import com.prof18.airalo.core.model.ImageUrl
import com.prof18.airalo.countrychooser.presentation.state.CountriesState
import com.prof18.airalo.countrychooser.presentation.state.CountriesState.Content.CountryItem

internal class CountriesPreviewProvider : PreviewParameterProvider<CountriesState> {

    companion object {
        val errorState = CountriesState.Error(
            content = "Something unexpected just happened. Please try again!",
            retryButtonText = "Retry",
            onRetryClick = {},
        )

        val contentState = CountriesState.Content(
            headerTitle = "Popular Countries",
            countryItems = listOf(
                CountryItem(
                    name = "Italy",
                    id = CountryId(
                        value = "italy",
                    ),
                    flagImageUrl = ImageUrl(
                        url = "https://cdn.airalo.com/images/5d7cdb58-591c-45d6-a9d1-050829acd0ab.png",
                    ),
                ),
                CountryItem(
                    name = "Germany",
                    id = CountryId(
                        value = "germany",
                    ),
                    flagImageUrl = ImageUrl(
                        url = "https://cdn.airalo.com/images/5d7cdb58-591c-45d6-a9d1-050829acd0ab.png",
                    ),
                ),
                CountryItem(
                    name = "USA",
                    id = CountryId(
                        value = "usa",
                    ),
                    flagImageUrl = ImageUrl(
                        url = "https://cdn.airalo.com/images/5d7cdb58-591c-45d6-a9d1-050829acd0ab.png",
                    ),
                ),
            ),
        )
    }

    override val values: Sequence<CountriesState>
        get() = sequenceOf(
            contentState,
            errorState,
            CountriesState.Loading,
        )
}
