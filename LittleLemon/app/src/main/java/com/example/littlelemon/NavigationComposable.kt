import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.Home
import com.example.littlelemon.HomeScreen
import com.example.littlelemon.Onboard
import com.example.littlelemon.Onboarding
import com.example.littlelemon.Profile
import com.example.littlelemon.ProfileScreen
import com.example.littlelemon.UserData

@Composable
fun Navigation(
    sharedPreferences: SharedPreferences,
    userData: UserData
) {

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