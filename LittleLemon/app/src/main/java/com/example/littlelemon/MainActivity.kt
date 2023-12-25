package com.example.littlelemon

import Navigation
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {

    private val sharedPreferences by lazy {
        getSharedPreferences(
            "Little Lemon",
            MODE_PRIVATE
        )
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                AppScreen(sharedPreferences,
                    UserData(
                        "",
                        "",
                        ""
                    )
                )

            }
        }
    }
}

@Composable
fun AppScreen(
    sharedPreferences: SharedPreferences,
    userData: UserData
) {
    Navigation(
        sharedPreferences = sharedPreferences,
        userData = userData
    )
}