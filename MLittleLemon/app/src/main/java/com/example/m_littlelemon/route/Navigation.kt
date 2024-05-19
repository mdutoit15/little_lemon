package com.example.m_littlelemon.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.m_littlelemon.screens.Login
import com.example.m_littlelemon.screens.Profile

@Composable
fun Navigate(
    navControl: NavHostController
) {
    NavHost(
        navController = navControl,
        startDestination = LoginS.route
    ) {
        composable(LoginS.route) {
            Login(navControl)
        }

        composable(Prof.route) {
            Profile(navControl)
        }
    }
}