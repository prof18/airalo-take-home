package com.prof18.airalo.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.prof18.airalo.designsystem.theme.AiraloTheme
import com.prof18.airalo.designsystem.theme.Spacings

@Composable
fun ErrorView(
    title: String,
    buttonText: String,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = Spacings.spacing20),
            text = title,
            textAlign = TextAlign.Center,
        )

        Button(
            modifier = Modifier
                .padding(top = Spacings.spacing10)
                .padding(horizontal = Spacings.spacing20),
            onClick = onRetryClick,
        ) {
            Text(
                text = buttonText,
            )
        }
    }
}

@Preview(
    backgroundColor = 0xffffff,
    showBackground = true,
)
@Composable
private fun EmptyShopContentPreview() {
    AiraloTheme {
        ErrorView(
            title = "Sorry, something went wrong",
            buttonText = "Retry",
            onRetryClick = {},
        )
    }
}
