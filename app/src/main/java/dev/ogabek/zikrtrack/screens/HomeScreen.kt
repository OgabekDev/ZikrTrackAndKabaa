package dev.ogabek.zikrtrack.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.ogabek.zikrtrack.R
import dev.ogabek.zikrtrack.model.BottomNavItem
import dev.ogabek.zikrtrack.navigation.Home
import dev.ogabek.zikrtrack.navigation.HomeNavigation
import dev.ogabek.zikrtrack.utils.BottomNavigationBar

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val route = navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                list = listOf(
                    BottomNavItem(
                        name = "TasbihScreen",
                        icon =  painterResource(id = R.drawable.ic_btm_3),
                        route = Home.TASBIH
                    ),
                    BottomNavItem(
                        name = "Qiblaa",
                        icon =  painterResource(id = R.drawable.ic_kabaa),
                        route = Home.QIBLAA
                    ),
                    BottomNavItem(
                        name = "Settings",
                        icon =  painterResource(id = R.drawable.ic_settings),
                        route = Home.SETTINGS
                    )

                ),
                navController = navController,
                onItemClick = {
                    if (it.route != route.value?.destination?.route)
                        navController.navigate(it.route)
                },
                modifier = Modifier
                    .height(70.dp)
            )
        },
    ) {
        HomeNavigation(navController = navController)
        Row(
            modifier = Modifier
                .padding(it.calculateBottomPadding())
        ) {}
    }

}