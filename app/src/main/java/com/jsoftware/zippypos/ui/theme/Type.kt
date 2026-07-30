package com.jsoftware.zippypos.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jsoftware.zippypos.R

// Set of Material typography styles to start with



val JosefinSans = FontFamily(
    Font(
        resId = R.font.josefin_sans_thin,
        weight = FontWeight.Thin,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.josefin_sans_thin_italic,
        weight = FontWeight.Thin,
        style = FontStyle.Italic
    ),

    Font(
        resId = R.font.josefin_sans_extra_light,
        weight = FontWeight.ExtraLight,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.josefin_sans_extra_light_italic,
        weight = FontWeight.ExtraLight,
        style = FontStyle.Italic
    ),

    Font(
        resId = R.font.josefin_sans_light,
        weight = FontWeight.Light,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.josefin_sans_light_italic,
        weight = FontWeight.Light,
        style = FontStyle.Italic
    ),

    Font(
        resId = R.font.josefin_sans_regular,
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.josefin_sans_italic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic
    ),

    Font(
        resId = R.font.josefin_sans_medium,
        weight = FontWeight.Medium,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.josefin_sans_medium_italic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),

    Font(
        resId = R.font.josefin_sans_semi_bold,
        weight = FontWeight.SemiBold,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.josefin_sans_semi_bold_italic,
        weight = FontWeight.SemiBold,
        style = FontStyle.Italic
    ),

    Font(
        resId = R.font.josefin_sans_bold,
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.josefin_sans_bold_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    )
)


//val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = JosefinSans,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    ),
//
//    bodyMedium = TextStyle(
//        fontFamily = JosefinSans,
//        fontWeight = FontWeight.Normal,
//        fontSize = 14.sp,
//        lineHeight = 20.sp
//    ),
//
//    titleLarge = TextStyle(
//        fontFamily = JosefinSans,
//        fontWeight = FontWeight.SemiBold,
//        fontSize = 22.sp,
//        lineHeight = 28.sp
//    ),
//
//    titleMedium = TextStyle(
//        fontFamily = JosefinSans,
//        fontWeight = FontWeight.Medium,
//        fontSize = 16.sp,
//        lineHeight = 24.sp
//    ),
//
//    labelLarge = TextStyle(
//        fontFamily = JosefinSans,
//        fontWeight = FontWeight.SemiBold,
//        fontSize = 14.sp,
//        lineHeight = 20.sp
//    )
//)




private fun Typography.withFontFamily(
    fontFamily: FontFamily
): Typography = Typography(
    displayLarge = displayLarge.copy(fontFamily = fontFamily),
    displayMedium = displayMedium.copy(fontFamily = fontFamily),
    displaySmall = displaySmall.copy(fontFamily = fontFamily),

    headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
    headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
    headlineSmall = headlineSmall.copy(fontFamily = fontFamily),

    titleLarge = titleLarge.copy(fontFamily = fontFamily),
    titleMedium = titleMedium.copy(fontFamily = fontFamily),
    titleSmall = titleSmall.copy(fontFamily = fontFamily),

    bodyLarge = bodyLarge.copy(fontFamily = fontFamily),
    bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
    bodySmall = bodySmall.copy(fontFamily = fontFamily),

    labelLarge = labelLarge.copy(fontFamily = fontFamily),
    labelMedium = labelMedium.copy(fontFamily = fontFamily),
    labelSmall = labelSmall.copy(fontFamily = fontFamily)
)

val AppTypography = Typography()
    .withFontFamily(JosefinSans)