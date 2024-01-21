package com.example.littlelemon_final11

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home.route
    ) {
        composable(Onboard.route) {
            Onboarding(navController)
        }

        composable(Home.route) {
            HomeScreen(navController)
        }

        composable(Profile.route) {
            ProfileScreen(navController)
        }
    }
}