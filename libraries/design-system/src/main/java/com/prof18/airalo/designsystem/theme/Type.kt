package com.prof18.airalo.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.prof18.airalo.uicomponents.R

private val ibmPlexFontFamily = FontFamily(
    Font(R.font.ibmplexsans_semibold, FontWeight.SemiBold),
    Font(R.font.ibmplexsans_medium, FontWeight.Medium),
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = ibmPlexFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 27.sp,
        lineHeight = 32.sp,
        letterSpacing = (-0.5).sp,
    ),
    titleMedium = TextStyle(
        fontFamily = ibmPlexFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 19.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.2).sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = ibmPlexFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 20.sp,
    ),

    bodySmall = TextStyle(
        fontFamily = ibmPlexFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        lineHeight = 15.sp,
        letterSpacing = (-0.1).sp,
    ),

    labelLarge = TextStyle(
        fontFamily = ibmPlexFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.1).sp,
    ),

    labelMedium = TextStyle(
        fontFamily = ibmPlexFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        lineHeight = 14.sp,
        letterSpacing = 1.sp,
    ),

    labelSmall = TextStyle(
        fontFamily = ibmPlexFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        lineHeight = 11.sp,
        letterSpacing = 1.sp,
    ),
)
