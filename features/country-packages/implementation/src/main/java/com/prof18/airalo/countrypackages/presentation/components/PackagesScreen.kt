package com.prof18.airalo.countrypackages.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.prof18.airalo.countrypackages.presentation.state.PackagesState
import com.prof18.airalo.designsystem.components.ErrorView
import com.prof18.airalo.designsystem.components.Loader
import com.prof18.airalo.designsystem.theme.AiraloTheme
import com.prof18.airalo.designsystem.theme.TextColor

@Composable
internal fun PackagesScreen(
    packagesState: PackagesState,
    onBackClick: () -> Unit,
) {
    var appBarTitle by remember {
        mutableStateOf("")
    }

    AiraloTheme {
        Scaffold(
            topBar = {
                PackagesScreenNavBar(
                    appBarTitle = appBarTitle,
                    onBackClick = onBackClick,
                )
            },
        ) { paddingValues ->
            when (packagesState) {
                PackagesState.Loading -> Loader(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                )

                is PackagesState.Error -> ErrorView(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    title = packagesState.content,
                    buttonText = packagesState.retryButtonText,
                    onRetryClick = packagesState.onRetryClick,
                )

                is PackagesState.Empty -> {
                    appBarTitle = packagesState.headerTitle

                    ErrorView(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
                        title = packagesState.errorMessage,
                        buttonText = packagesState.retryButtonText,
                        onRetryClick = packagesState.onRetryClick,
                    )
                }

                is PackagesState.Content -> {
                    appBarTitle = packagesState.headerTitle
                    PackagesList(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxWidth(),
                        packagesContent = packagesState,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PackagesScreenNavBar(
    appBarTitle: String,
    onBackClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = appBarTitle,
                style = MaterialTheme.typography.titleLarge,
                color = TextColor,
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.White,
        ),
        navigationIcon = {
            IconButton(
                onClick = onBackClick,
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                )
            }
        },
    )
}

@Preview
@Composable
private fun PackagesScreenPreview(
    @PreviewParameter(PackagesScreenPreviewProvider::class) state: PackagesState,

) {
    PackagesScreen(
        packagesState = state,
        onBackClick = {},
    )
}
