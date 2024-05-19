package com.example.m_littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.m_littlelemon.route.Navigate
import com.example.m_littlelemon.screens.Home
import com.example.m_littlelemon.screens.Login
import com.example.m_littlelemon.ui.theme.MLittleLemonTheme
import com.example.m_littlelemon.ui.theme.White

class MainActivity : ComponentActivity() {

    /* private val sharedPref by lazy {
        getSharedPreferences("Shared Preference", MODE_PRIVATE)
    } */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MLittleLemonTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color.White
                ) {
                    /* val navControl = rememberNavController()
                    Navigate(navControl) */
                    Home()
                }
            }
        }
    }
}