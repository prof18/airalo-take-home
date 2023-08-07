package com.prof18.airalo.countrypackages.presentation.components

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.prof18.airalo.core.model.ImageUrl
import com.prof18.airalo.countrypackages.R
import com.prof18.airalo.countrypackages.domain.model.ColorGradient
import com.prof18.airalo.countrypackages.presentation.state.PackagesState
import com.prof18.airalo.countrypackages.presentation.state.PackagesState.Content.PackageItem.PackageFeature

internal class PackagesScreenPreviewProvider : PreviewParameterProvider<PackagesState> {
    companion object {
        val errorState = PackagesState.Error(
            content = "Something unexpected just happened. Please try again!",
            retryButtonText = "Retry",
            onRetryClick = {},
        )

        val emptyState = PackagesState.Empty(
            headerTitle = "Italy",
            errorMessage = "Sorry, no packages are avaiable for this country",
            retryButtonText = "Retry",
            onRetryClick = {},
        )

        val contentState = PackagesState.Content(
            headerTitle = "Italy",
            packageItems = listOf(
                PackagesState.Content.PackageItem(
                    title = "Burj Mobile",
                    subtitle = "United Arab Emirates",
                    imageUrl = ImageUrl(url = "https://www.imageUrl.com"),
                    cardGradient = ColorGradient(
                        startColor = "#EC802C",
                        endColor = "#F9DF8D",
                    ),
                    features = listOf(
                        PackageFeature(
                            iconRes = R.drawable.ic_data,
                            title = "DATA",
                            amountLabel = "1 GB",
                        ),
                        PackageFeature(
                            iconRes = R.drawable.ic_validity,
                            title = "VALIDITY",
                            amountLabel = "7 Days",
                        ),
                    ),
                    buttonText = "US\$8.50 - BUY NOW",
                    onButtonClick = {},
                ),
                PackagesState.Content.PackageItem(
                    title = "Burj Mobile",
                    subtitle = "United Arab Emirates",
                    imageUrl = ImageUrl(url = "https://www.imageUrl.com"),
                    cardGradient = ColorGradient(
                        startColor = "#EC802C",
                        endColor = "#F9DF8D",
                    ),
                    features = listOf(
                        PackageFeature(
                            iconRes = R.drawable.ic_data,
                            title = "DATA",
                            amountLabel = "1 GB",
                        ),
                        PackageFeature(
                            iconRes = R.drawable.ic_validity,
                            title = "VALIDITY",
                            amountLabel = "7 Days",
                        ),
                    ),
                    buttonText = "US\$8.50 - BUY NOW",
                    onButtonClick = {},
                ),
            ),
        )
    }

    override val values: Sequence<PackagesState>
        get() = sequenceOf(
            contentState,
            errorState,
            emptyState,
            PackagesState.Loading,
        )
}
