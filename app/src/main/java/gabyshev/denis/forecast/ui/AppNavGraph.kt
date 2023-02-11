package gabyshev.denis.forecast.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import gabyshev.denis.forecast.core.common.navigation.register
import gabyshev.denis.forecast.feature.select_city.SelectCityApi

@Composable
fun AppNavGraph(
    modifier: Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = SelectCityApi.selectCityRoute()
    ) {
        register(
            SelectCityApi,
            navController = navController,
            modifier = modifier
        )
    }
}