package com.prof18.airalo.countrychooser.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.prof18.airalo.core.model.CountryId
import com.prof18.airalo.core.model.ImageUrl
import com.prof18.airalo.countrychooser.R
import com.prof18.airalo.countrychooser.presentation.state.CountriesState
import com.prof18.airalo.designsystem.theme.AiraloTheme
import com.prof18.airalo.designsystem.theme.Spacings

@Composable
internal fun CountriesList(
    state: CountriesState.Content,
    modifier: Modifier = Modifier,
    onCountryClick: (CountryId) -> Unit,
) {
    // TODO: check paddings
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = Spacings.spacing15),
            text = state.headerTitle,
            style = MaterialTheme.typography.titleMedium,
        )

        LazyColumn(
            contentPadding = PaddingValues(
                vertical = Spacings.spacing10,
            ),
            verticalArrangement = Arrangement.spacedBy(Spacings.spacing10)
        ) {
            items(state.countryItems) { countryItem ->

                Card(
                    shape = RoundedCornerShape(Spacings.cornerRadius),
                    modifier = Modifier
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(
                                size = Spacings.cornerRadius,
                            ),
                            clip = true,
                        )

                        .clickable {
                            onCountryClick(countryItem.id)
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    ),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        FlagImage(
                            modifier = Modifier
                                .padding(start = Spacings.spacing20)
                                .padding(vertical = Spacings.spacing15),
                            countryItem.flagImageUrl,
                        )

                        Text(
                            modifier = Modifier
                                .padding(start = Spacings.spacing15)
                                .weight(1f),
                            text = countryItem.name,
                        )

                        Icon(
                            modifier = Modifier
                                .padding(end = Spacings.spacing20),
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun FlagImage(
    modifier: Modifier = Modifier,
    imageUrl: ImageUrl,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        AsyncImage(
            modifier = modifier
                .width(37.dp)
                .height(28.dp),
            contentScale = ContentScale.Crop,
            model = imageUrl.url,
            contentDescription = null,
        )
    } else {
        Box(
            modifier = modifier
                .width(37.dp)
                .height(28.dp)
                .background(Color.Green),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CountriesScreenPreview() {
    AiraloTheme {
        CountriesList(
            state = CountriesPreviewProvider.contentState,
            onCountryClick = {},
        )
    }
}
