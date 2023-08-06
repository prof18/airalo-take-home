package com.prof18.airalo.countrypackages.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.prof18.airalo.countrypackages.presentation.state.PackagesState
import com.prof18.airalo.designsystem.theme.AiraloTheme
import com.prof18.airalo.designsystem.theme.Spacings

@Composable
internal fun PackagesList(
    packagesContent: PackagesState.Content,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            vertical = Spacings.spacing10,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spacings.spacing20),

    ) {
        items(packagesContent.packageItems) { packageItem ->
            PackageCard(packageItem = packageItem)
        }
    }
}

@Preview
@Composable
private fun PackagesListPreview() {
    AiraloTheme {
        PackagesList(packagesContent = PackagesScreenPreviewProvider.contentState)
    }
}
