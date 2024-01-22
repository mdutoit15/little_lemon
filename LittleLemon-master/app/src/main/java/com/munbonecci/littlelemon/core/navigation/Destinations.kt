package com.munbonecci.littlelemon.core.navigation

import com.munbonecci.littlelemon.Constants.DISH_DETAIL_SCREEN
import com.munbonecci.littlelemon.Constants.HOME_SCREEN
import com.munbonecci.littlelemon.Constants.ON_BOARDING_SCREEN
import com.munbonecci.littlelemon.Constants.PROFILE_SCREEN

interface Destinations {
    val route: String
}

object OnBoard : Destinations {
    override val route = ON_BOARDING_SCREEN
}

object Home : Destinations {
    override val route = HOME_SCREEN
}

object Profile : Destinations {
    override val route = PROFILE_SCREEN
}

object DishDetail : Destinations {
    override val route =
        "${DISH_DETAIL_SCREEN}/{itemId}"
}