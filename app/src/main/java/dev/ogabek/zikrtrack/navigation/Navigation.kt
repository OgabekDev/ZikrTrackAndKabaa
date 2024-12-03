package dev.ogabek.zikrtrack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.ogabek.zikrtrack.model.Tasbih
import dev.ogabek.zikrtrack.screens.SettingsScreen
import dev.ogabek.zikrtrack.screens.TasbihDetailsScreen
import dev.ogabek.zikrtrack.screens.QiblaaScreen
import dev.ogabek.zikrtrack.screens.TasbihScreen

@Composable
fun HomeNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Home.TASBIH
    ) {
        composable(Home.TASBIH) {
            TasbihScreen(navController)
        }
        composable(Home.QIBLAA) {
            QiblaaScreen(navController)
        }
        composable(Home.SETTINGS) {
            SettingsScreen(navController)
        }
        tasbihDetailsScreen(navController)
    }
}

fun NavGraphBuilder.tasbihDetailsScreen(navController: NavHostController) {
    navigation(
        route = Graph.TASBIH,
        startDestination = Screen.TASBIH,
    ) {
        composable(
            route = Screen.TASBIH,
        ) {
            val tasbih =
                navController.previousBackStackEntry?.savedStateHandle?.get<Tasbih>("tasbih")
            TasbihDetailsScreen(navController, tasbih)
        }
    }
}