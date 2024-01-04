package com.godi.mynitacompose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.godi.mynitacompose.ui.theme.NitaThemeDesignSystem.LocalNitaTheme
import com.godi.mynitacompose.ui.theme.NitaThemeDesignSystem.NitaThemeColors

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun MyNitaComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicLightColorScheme(context) else dynamicLightColorScheme(context)
        }
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.White.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}


object NitaThemeDesignSystem {
    @Immutable
    data class NitaThemeColors(
        val burntSienna: Color,
        val lightSienna: Color,
        val cobaltBlue: Color,
        val powderBlue: Color,
        val stealBlue: Color,
        val dimGray: Color,
        val forestGreen: Color
    )

    val nitaThemeColors = NitaThemeColors(
        burntSienna = Color(0xFFE75922),
        lightSienna = Color(0xFFFFF2ED),
        cobaltBlue = Color(0xFF014E93),
        powderBlue = Color(0xFFDCE8F7),
        stealBlue = Color(0xFF2BA2D2),
        dimGray = Color(0xFF444444),
        forestGreen = Color(0xFF1D5F2E)
    )

    val LocalNitaTheme = staticCompositionLocalOf {
        nitaThemeColors
    }
}

@Composable
fun NitaTheme(
    content: @Composable () -> Unit
) {
    val nitaThemeColors = NitaThemeDesignSystem.nitaThemeColors

    CompositionLocalProvider(LocalNitaTheme provides nitaThemeColors) {
        MaterialTheme(
            content = content,
            typography = Typography
        )
    }
}

object NitaTheme {
    val colors: NitaThemeColors
        @Composable
        get() = LocalNitaTheme.current
}