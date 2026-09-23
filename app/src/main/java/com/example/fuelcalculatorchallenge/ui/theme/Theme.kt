package com.example.fuelcalculatorchallenge.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = FuelNavy,
    // Texto/ícones sobre primary
    onPrimary = FuelWhite,

    secondary = FuelBlue,
    // Texto/ícones sobre secondary
    onSecondary = FuelNavy,

    tertiary = FuelPink,
    // Texto/ícones sobre tertiary
    onTertiary = FuelWhite,

    background = FuelWhite,
    // Texto sobre background
    onBackground = FuelNavy,

    // Superfícies como Cards
    surface = FuelWhite,
    // Texto sobre superfícies
    onSurface = FuelNavy,

    // Campos / superfícies secundárias
    surfaceVariant = FuelLightGray,
    onSurfaceVariant = FuelDarkGray,

    // Bordas
    outline = FuelBlueDark
)

private val DarkColorScheme = darkColorScheme(

    primary = FuelBlue,
    onPrimary = FuelNavy,

    secondary = FuelNavy,
    onSecondary = FuelWhite,

    tertiary = FuelPink,
    onTertiary = FuelWhite,

    background = FuelNavy,
    onBackground = FuelWhite,

    surface = FuelNavy,
    onSurface = FuelWhite,

    surfaceVariant = FuelBlueDark,
    onSurfaceVariant = FuelWhite,

    outline = FuelBlue
)

@Composable
fun FuelCalculatorChallengeTheme(
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
        typography = Typography,
        content = content
    )
}