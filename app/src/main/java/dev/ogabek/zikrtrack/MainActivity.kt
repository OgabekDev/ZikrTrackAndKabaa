package dev.ogabek.zikrtrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.ogabek.zikrtrack.screens.HomeScreen
import dev.ogabek.zikrtrack.ui.theme.MainTheme
import dev.ogabek.zikrtrack.utils.*

var myPitch = mutableStateOf(0f)
var myRoll = mutableStateOf(0f)
var myYaw = mutableStateOf(0f)

@AndroidEntryPoint
class MainActivity : ComponentActivity(), Orientation.Listener {

    private lateinit var mOrientation: Orientation

    override fun onCreate(savedInstanceState: Bundle?) {

        mOrientation = Orientation(this)

        super.onCreate(savedInstanceState)
        setContent {
            SetSystemColor()

            loadLocale(this)

            MainTheme(darkTheme = isDarkMode()) {

                HomeScreen(rememberNavController())

            }
        }
    }

    override fun onOrientationChanged(pitch: Float, roll: Float, yaw: Float) {
        myPitch.value = pitch
        myRoll.value = roll
        myYaw.value = yaw
    }

    override fun onStart() {
        super.onStart()
        mOrientation.startListening(this)
    }

    override fun onStop() {
        super.onStop()
        mOrientation.stopListening()
    }

}