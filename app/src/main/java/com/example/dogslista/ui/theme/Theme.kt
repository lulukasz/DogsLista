package com.example.dogslista.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Purple200,
    secondary = Teal200,
    background = Black,
    surface = Black,
    onSurface = White,
    onBackground = White
)

private val LightColorScheme = lightColorScheme(
    primary = Purple500,
    secondary = Teal200,
    background = White,
    surface = White,
    onSurface = Black,
    onBackground = Black
)

@Composable
fun DogsListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
