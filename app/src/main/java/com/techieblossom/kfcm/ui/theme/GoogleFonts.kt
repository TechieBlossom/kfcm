package com.techieblossom.kfcm.ui.theme

import androidx.compose.ui.text.googlefonts.GoogleFont
import com.techieblossom.kfcm.R

val googleFontProvider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)