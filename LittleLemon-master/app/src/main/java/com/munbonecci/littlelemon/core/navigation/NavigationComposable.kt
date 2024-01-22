package com.munbonecci.littlelemon.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.munbonecci.littlelemon.Constants.ITEM_ID
import com.munbonecci.littlelemon.presentation.dish_detail.DishDetail
import com.munbonecci.littlelemon.presentation.home.Home
import com.munbonecci.littlelemon.presentation.profile.Profile
import com.munbonecci.littlelemon.presentation.register.OnBoarding

@Composable
fun NavigationComposable(
    navController: NavHostController,
    isRegistered: Boolean
) {
    val startDestinationRoute =
        if (isRegistered)
            Home.route
        else
            OnBoard.route

    NavHost(
        navController = navController,
        startDestination = startDestinationRoute
    ) {
        composable(OnBoard.route) {
            OnBoarding(navController)
        }
        composable(Home.route) {
            Home(navController,
                onItemPressed = {
                    navController.navigate(
                        "${DishDetail.route}/${it.id}"
                    )
                }
            )
        }
        composable(Profile.route) {
            Profile(navController)
        }
        composable(
            route = "${DishDetail.route}/{itemId}",
            arguments = listOf(
                navArgument(ITEM_ID) { type = NavType.StringType },
            )
        ) { navStackEntry ->
            DishDetail(
                onBackButtonClicked = {
                    navController.navigate(Home.route)
                },
                navStackEntry.arguments?.getString(ITEM_ID, ""),
            )
        }
    }
}