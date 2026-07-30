package com.jsoftware.zippypos.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color(0xFF101719),
    onBackground = Color(0xFFDCEDEF),

    surface = Color(0xFF191E20),
    onSurface = Color(0xFFE5E2DF),

    surfaceVariant = Color(0xFF263438),
    onSurfaceVariant = Color(0xFFC3CDD0),

    secondaryContainer = Color(0xFF294248),
    onSecondaryContainer = Color(0xFFD4F3F8),

    primaryContainer = Color(0xFF6A4022),
    onPrimaryContainer = Color(0xFFFFDBC2),

    outline = Color(0xFF899497)
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color(0xFFEAF7FB),
    onBackground = Color(0xFF1A1C1D),

    surface = Color(0xFFFFF8F3),
    onSurface = Color(0xFF302B27),

    surfaceVariant = Color(0xFFDDECEF),
    onSurfaceVariant = Color(0xFF554F4A),

    secondaryContainer = Color(0xFFDCEFF3),
    onSecondaryContainer = Color(0xFF25383C),

    primaryContainer = Color(0xFFFFD9BC),
    onPrimaryContainer = Color(0xFF4A260D),

    outline = Color(0xFF8E8178)
)

@Composable
fun ZippyPOSTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography =  AppTypography,
        content = content
    )
}