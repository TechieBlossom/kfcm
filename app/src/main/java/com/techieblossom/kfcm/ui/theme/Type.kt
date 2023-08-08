package com.techieblossom.kfcm.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.techieblossom.kfcm.R

//val poppinsGoogleFont = GoogleFont("Poppins")
//val poppinsFont = Font(googleFont = poppinsGoogleFont, fontProvider = googleFontProvider)
//val poppinsFontFamily = FontFamily(poppinsFont)

val dinProFontFamily = FontFamily(
    androidx.compose.ui.text.font.Font(R.font.din_pro, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = dinProFontFamily,
        fontSize = 32.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = dinProFontFamily,
        fontSize = 20.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = dinProFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
    ),
    titleSmall = TextStyle(
      fontFamily = dinProFontFamily,
        fontSize = 14.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = dinProFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = dinProFontFamily,
        fontSize = 14.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = dinProFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = dinProFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
    )
)

val CompactTypography = Typography(
    labelSmall = TextStyle(
        fontFamily = dinProFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
    )
)