package dev.ogabek.zikrtrack.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.ogabek.zikrtrack.R
import java.util.*

@Composable
fun SetSystemColor() {
    // Remember a SystemUIController
    val systemUIController = rememberSystemUiController()
    val useDarkIcons = !isDarkMode()

    DisposableEffect(systemUIController, useDarkIcons) {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme

        systemUIController.setSystemBarsColor(
            color = if (useDarkIcons) Color(0xFFFFFFFF) else Color(0xFF232323),
            darkIcons = useDarkIcons
        )

        // setStatusBarColor and setNavigationBarColor also exist

        onDispose {}
    }
}

@Composable
fun isDarkMode(): Boolean {
    val context = LocalContext.current
    return SharedDatabase(context).getBoolean("isDarkMode")
}

fun changeMode(context: Context, isDarkMode: Boolean) {
    SharedDatabase(context).saveBoolean("isDarkMode", isDarkMode)
}

val interRegular = Font(R.font.inter_regular)
val poppinsMedium = Font(R.font.poppins_medium)
val poppinsRegular = Font(R.font.poppins_regular)

fun loadLocale(context: Context) {
    val language = SharedDatabase(context).getLanguage()
    val locale = Locale(language ?: "eng")
    Locale.setDefault(locale)
    val resources = context.resources
    val configuration = resources.configuration
    configuration.setLocale(locale)
    resources.updateConfiguration(configuration, resources.displayMetrics)
}