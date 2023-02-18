package gabyshev.denis.forecast

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import gabyshev.denis.forecast.core.common.LocalAppDependenciesProvider
import gabyshev.denis.forecast.core.common.find
import gabyshev.denis.forecast.feature.select_city.SelectCityEntry
import gabyshev.denis.forecast.feature.weather.WeatherEntry

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalAppDependenciesProvider.current.destinations

    val selectCityScreen = destinations.find<SelectCityEntry>()
    val weatherScreen = destinations.find<WeatherEntry>()

    Box(Modifier.fillMaxSize()) {
        NavHost(navController = navController, startDestination = weatherScreen.destination()) {

            with(selectCityScreen) {
                composable(navController, destinations)
            }

            with(weatherScreen) {
                composable(navController, destinations)
            }
        }
    }
}
