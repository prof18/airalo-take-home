package com.prof18.airalo.countrypackages.presentation.state

import androidx.annotation.DrawableRes
import com.prof18.airalo.core.model.ImageUrl
import com.prof18.airalo.countrypackages.domain.model.ColorGradient

internal sealed interface PackagesState {
    data object Loading : PackagesState

    data class Error(
        val content: String,
        val retryButtonText: String,
        val onRetryClick: () -> Unit,
    ) : PackagesState

    data class Empty(
        val headerTitle: String,
        val errorMessage: String,
        val retryButtonText: String,
        val onRetryClick: () -> Unit,
    ) : PackagesState

    data class Content(
        val headerTitle: String,
        val packageItems: List<PackageItem>,
    ) : PackagesState {
        data class PackageItem(
            val title: String,
            val subtitle: String,
            val imageUrl: ImageUrl,
            val cardGradient: ColorGradient,
            val features: List<PackageFeature>,
            val buttonText: String,
            val onButtonClick: () -> Unit,
        ) {
            data class PackageFeature(
                @DrawableRes val iconRes: Int,
                val title: String,
                val amountLabel: String,
            )
        }
    }
}
