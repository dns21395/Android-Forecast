package gabyshev.denis.forecast.feature.weather

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import gabyshev.denis.forecast.core.common.Destinations
import gabyshev.denis.forecast.weather_day.WeekDay
import javax.inject.Inject

class WeatherEntryImpl @Inject constructor(): WeatherEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
    ) {
        WeekDay()
    }
}