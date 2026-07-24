package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = DarkBrownPrimary,
    onPrimary = DarkBrownOnPrimary,
    primaryContainer = DarkBrownPrimaryContainer,
    onPrimaryContainer = DarkBrownOnPrimaryContainer,
    secondary = DarkBrownSecondary,
    surface = DarkBrownSurface,
    onSurface = DarkBrownOnSurface,
    onSurfaceVariant = DarkBrownOnSurfaceVariant,
    outline = DarkBrownOutline
)

private val LightColorScheme = lightColorScheme(
    primary = BrownPrimary,
    onPrimary = BrownOnPrimary,
    primaryContainer = BrownPrimaryContainer,
    onPrimaryContainer = BrownOnPrimaryContainer,
    secondary = BrownSecondary,
    surface = BrownSurface,
    onSurface = BrownOnSurface,
    onSurfaceVariant = BrownOnSurfaceVariant,
    outline = BrownOutline
)

val LocalBackgroundGradient = staticCompositionLocalOf {
    Brush.verticalGradient(listOf(Color.White, Color.White))
}

@Composable
fun ProfileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val gradient = if (darkTheme) {
        Brush.verticalGradient(
            colors = listOf(DarkBrownBackgroundStart, DarkBrownBackgroundEnd)
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(BrownBackgroundStart, BrownBackgroundEnd)
        )
    }

    CompositionLocalProvider(LocalBackgroundGradient provides gradient) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
