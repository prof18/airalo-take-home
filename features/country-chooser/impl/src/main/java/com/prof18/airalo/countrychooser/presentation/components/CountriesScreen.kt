@file:OptIn(ExperimentalMaterial3Api::class)

package com.prof18.airalo.countrychooser.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.prof18.airalo.core.R
import com.prof18.airalo.core.model.CountryId
import com.prof18.airalo.countrychooser.presentation.state.CountriesState
import com.prof18.airalo.designsystem.components.ErrorView
import com.prof18.airalo.designsystem.components.Loader
import com.prof18.airalo.designsystem.theme.AiraloTheme
import com.prof18.airalo.designsystem.theme.Spacings

@Composable
internal fun CountriesScreen(
    state: CountriesState,
    onCountryClick: (CountryId) -> Unit,
) {
    AiraloTheme {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.country_chooser_nav_bar_title),
                            style = MaterialTheme.typography.titleLarge,
                        )
                    },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color.White,
                    ),
                )
            },
        ) { paddingValues ->
            when (state) {
                CountriesState.Loading -> Loader(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                )

                is CountriesState.Error -> ErrorView(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    title = state.content,
                    buttonText = state.retryButtonText,
                    onRetryClick = state.onRetryClick,
                )

                is CountriesState.Content -> CountriesList(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(top = Spacings.spacing30)
                        .padding(horizontal = Spacings.spacing20),
                    state = state,
                    onCountryClick = onCountryClick,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CountriesScreenPreview(
    @PreviewParameter(CountriesPreviewProvider::class) state: CountriesState,
) {
    CountriesScreen(
        state = state,
        onCountryClick = {},
    )
}
