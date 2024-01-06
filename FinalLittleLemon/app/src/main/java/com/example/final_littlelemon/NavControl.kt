package com.example.final_littlelemon

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(
    sharedPreferences: SharedPreferences
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home.route
    ) {
        composable(Onboard.route) {
            Onboarding(navController, sharedPreferences)
        }

        composable(Home.route) {
            HomeScreen(navController)
        }

        composable(Profile.route) {
            ProfileScreen(navController)
        }
    }
}