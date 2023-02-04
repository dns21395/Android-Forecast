package gabyshev.denis.forecast.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gabyshev.denis.forecast.core.ui.theme.ForecastTheme
import gabyshev.denis.forecast.feature.select_city.ui.SelectCityScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ForecastTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "select_city") {
                    composable("select_city") { SelectCityScreen() }
                }
            }
        }
    }
}
