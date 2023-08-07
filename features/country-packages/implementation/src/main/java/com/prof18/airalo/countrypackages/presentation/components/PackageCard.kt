package com.prof18.airalo.countrypackages.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.prof18.airalo.core.model.ImageUrl
import com.prof18.airalo.countrypackages.presentation.state.PackagesState.Content.PackageItem
import com.prof18.airalo.countrypackages.presentation.state.PackagesState.Content.PackageItem.PackageFeature
import com.prof18.airalo.designsystem.theme.AiraloTheme
import com.prof18.airalo.designsystem.theme.DividerColor
import com.prof18.airalo.designsystem.theme.Spacings
import com.prof18.airalo.designsystem.theme.TextColor

@Composable
internal fun PackageCard(
    packageItem: PackageItem,
    modifier: Modifier = Modifier,
) {
    Box {
        Box(
            modifier = modifier
                .padding(top = Spacings.spacing20)
                .height(308.dp)
                .shadow(
                    elevation = Spacings.elevation,
                    shape = RoundedCornerShape(
                        size = Spacings.cornerRadius,
                    ),
                    clip = true,
                )
                .background(
                    brush = cardGradientColor(packageItem),
                    shape = RoundedCornerShape(Spacings.cornerRadius),
                ),
        ) {
            Column {
                Text(
                    modifier = Modifier
                        .padding(top = Spacings.spacing20)
                        .padding(horizontal = Spacings.spacing20),
                    text = packageItem.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = TextColor,
                )

                Text(
                    modifier = Modifier
                        .padding(top = Spacings.spacing5)
                        .padding(bottom = Spacings.spacing25)
                        .padding(horizontal = Spacings.spacing20),
                    text = packageItem.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextColor,
                )

                RowDivider()

                packageItem.features.forEach { feature ->
                    FeatureCard(feature = feature)
                }

                BuyButton(
                    modifier = Modifier
                        .padding(top = Spacings.spacing20)
                        .padding(horizontal = Spacings.spacing20),
                    packageItem,
                )
            }
        }

        CarrierImage(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = Spacings.spacing20),
            imageUrl = packageItem.imageUrl,
        )
    }
}

@Composable
private fun FeatureCard(feature: PackageFeature) {
    Column {
        Row(
            modifier = Modifier
                .padding(Spacings.spacing20)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = feature.iconRes),
                contentDescription = null,
                tint = TextColor,
            )

            Text(
                modifier = Modifier
                    .padding(start = Spacings.spacing10)
                    .weight(1f),
                text = feature.title,
                style = MaterialTheme.typography.labelMedium,
                color = TextColor,
            )

            Text(
                text = feature.amountLabel,
                style = MaterialTheme.typography.labelLarge,
                color = TextColor,
            )
        }

        RowDivider()
    }
}

@Composable
private fun BuyButton(
    modifier: Modifier = Modifier,
    packageItem: PackageItem,
) {
    OutlinedButton(
        modifier = modifier,
        shape = RoundedCornerShape(Spacings.cornerRadius),
        border = BorderStroke(
            width = 1.dp,
            color = TextColor,
        ),
        onClick = packageItem.onButtonClick,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = packageItem.buttonText,
            style = MaterialTheme.typography.labelSmall,
            color = TextColor,
        )
    }
}

@Composable
private fun RowDivider() {
    Divider(
        modifier = Modifier
            .height(1.dp)
            .background(
                color = DividerColor,
            ),
    )
}

@Composable
private fun cardGradientColor(packageItem: PackageItem) =
    Brush.horizontalGradient(
        colors = listOf(
            Color(packageItem.cardGradient.startColor.toColorInt()),
            Color(packageItem.cardGradient.endColor.toColorInt()),
        ),
    )

@Composable
private fun CarrierImage(
    modifier: Modifier = Modifier,
    imageUrl: ImageUrl,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        AsyncImage(
            modifier = modifier
                .width(140.dp)
                .height(88.dp)
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(
                        size = Spacings.cornerRadius,
                    ),
                    clip = false,
                )
                .clip(RoundedCornerShape(Spacings.cornerRadius)),
            contentScale = ContentScale.Crop,
            model = imageUrl.url,
            contentDescription = null,
        )
    } else {
        Box(
            modifier = modifier
                .width(140.dp)
                .height(88.dp)
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(
                        size = Spacings.cornerRadius,
                    ),
                    clip = true,
                )
                .background(Color.Green),
        )
    }
}

@Preview
@Composable
private fun PackageCardPreview() {
    AiraloTheme {
        PackageCard(
            packageItem = PackagesScreenPreviewProvider.contentState.packageItems.first(),
        )
    }
}
