package dev.ogabek.zikrtrack.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.ogabek.zikrtrack.R
import dev.ogabek.zikrtrack.myPitch
import dev.ogabek.zikrtrack.myRoll
import dev.ogabek.zikrtrack.myYaw
import dev.ogabek.zikrtrack.ui.theme.DarkBackgroundColor
import dev.ogabek.zikrtrack.ui.theme.LightBackgroundColor
import dev.ogabek.zikrtrack.utils.KabaaBackground
import dev.ogabek.zikrtrack.utils.TopBar
import dev.ogabek.zikrtrack.utils.isDarkMode

@Composable
fun QiblaaScreen() {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        KabaaBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            TopBar(
                title = stringResource(R.string.kabaa),
            )

        }
        Image(
            modifier = Modifier
                .size((screenWidth.value * 2).dp)
                .rotate(degrees = myYaw.value),
            painter = painterResource(id = R.drawable.compose),
            contentDescription = null
        )

        Image(
            modifier = Modifier
                .height((screenHeight.value / 4).dp)
                .width(20.dp)
                .rotate(degrees = myRoll.value),
            painter = painterResource(id = R.drawable.direction),
            contentDescription = null
        )

        Image(
            modifier = Modifier
                .size(60.dp)
                .rotate(degrees = myRoll.value),
            painter = painterResource(id = R.drawable.star),
            contentDescription = null
        )

        Icon(
            modifier = Modifier
                .size(20.dp),
            painter = painterResource(id = R.drawable.qibla),
            contentDescription = null,
            tint = if (isDarkMode()) DarkBackgroundColor else LightBackgroundColor
        )
    }

}