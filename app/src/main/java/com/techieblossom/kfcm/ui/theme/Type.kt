package com.techieblossom.kfcm.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp

val poppinsGoogleFont = GoogleFont("Poppins")
val poppinsFont = Font(googleFont = poppinsGoogleFont, fontProvider = googleFontProvider)
val poppinsFontFamily = FontFamily(poppinsFont)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 32.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 20.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    ),
    titleSmall = TextStyle(
      fontFamily = poppinsFontFamily,
        fontSize = 14.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 12.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
    ),
)