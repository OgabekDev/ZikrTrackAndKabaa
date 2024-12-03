package dev.ogabek.zikrtrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.ogabek.zikrtrack.screens.HomeScreen
import dev.ogabek.zikrtrack.ui.theme.MainTheme
import dev.ogabek.zikrtrack.utils.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetSystemColor()

            loadLocale(this)

            MainTheme(darkTheme = isDarkMode()) {

                HomeScreen(rememberNavController())

            }
        }
    }
}