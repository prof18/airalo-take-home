package com.prof18.airalo.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.prof18.airalo.designsystem.theme.AiraloTheme

@Composable
fun Loader(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center),
        )
    }
}

@Preview
@Composable
private fun FullScreenLoaderPreview() {
    AiraloTheme {
        Loader()
    }
}
