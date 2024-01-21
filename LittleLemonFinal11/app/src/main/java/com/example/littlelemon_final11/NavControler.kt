package com.example.littlelemon_final11

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Onboard.route
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