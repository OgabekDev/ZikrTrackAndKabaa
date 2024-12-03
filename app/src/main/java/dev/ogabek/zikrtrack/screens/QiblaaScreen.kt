package dev.ogabek.zikrtrack.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import dev.ogabek.zikrtrack.R
import dev.ogabek.zikrtrack.utils.TasbihDetailsBackground
import dev.ogabek.zikrtrack.utils.TopBar

@Composable
fun QiblaaScreen(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TasbihDetailsBackground()
        KabaaView()
    }

}

@Composable
fun KabaaView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ) {
        TopBar(
            title = stringResource(R.string.kabaa),
        )

        Box {

        }

    }
}
