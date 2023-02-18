package gabyshev.denis.forecast.feature.select_city

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import gabyshev.denis.forecast.core.common.Destinations
import gabyshev.denis.forecast.feature.select_city.ui.SelectCityScreen
import javax.inject.Inject

class SelectCityEntryImpl @Inject constructor() : SelectCityEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
    ) {
        SelectCityScreen()
    }
}
