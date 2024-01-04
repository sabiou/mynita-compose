package com.godi.mynitacompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.godi.mynitacompose.R


// Font Family
private val Exo = FontFamily(
    listOf(
        Font(R.font.exo_light, FontWeight.Light),
        Font(R.font.exo_thin, FontWeight.Thin),
        Font(R.font.exo_regular, FontWeight.Normal),
        Font(R.font.exo_bold, FontWeight.Bold),
        Font(R.font.exo_extra_bold, FontWeight.ExtraBold),
    )
)

private val GoogleSans = FontFamily(
    listOf(
        Font(R.font.google_sans_display_regular),
        Font(R.font.google_sans_display_bold, FontWeight.Bold),
        Font(R.font.google_sans_display_medium, FontWeight.Medium),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Exo,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)