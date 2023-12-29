import android.content.SharedPreferences
import android.view.MenuItem
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.Home
import com.example.littlelemon.HomeScreen
import com.example.littlelemon.MenuItemNetwork
import com.example.littlelemon.Onboard
import com.example.littlelemon.Onboarding
import com.example.littlelemon.Profile
import com.example.littlelemon.ProfileScreen

@Composable
fun Navigation(
    sharedPreferences: SharedPreferences) {

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