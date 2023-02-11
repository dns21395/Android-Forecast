package gabyshev.denis.forecast.feature.select_city

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import gabyshev.denis.forecast.core.common.navigation.FeatureApi
import gabyshev.denis.forecast.feature.select_city.ui.SelectCityScreen

object SelectCityApi : FeatureApi {

    private val baseRoute = "select_city"

    fun selectCityRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
    ) {
        navGraphBuilder.composable(baseRoute) {
            SelectCityScreen()
        }
    }
}