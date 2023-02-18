package gabyshev.denis.forecast.core.common

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable

typealias Destinations = Map<Class<out FeatureEntry>, @JvmSuppressWildcards FeatureEntry>

interface FeatureEntry {

    val featureRoute: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()
}

interface ComposableFeatureEntry : FeatureEntry {

    fun NavGraphBuilder.composable(navController: NavHostController, destinations: Destinations) {
        composable(featureRoute, arguments, deepLinks) { backStackEntry ->
            Composable(navController, destinations, backStackEntry)
        }
    }

    @Composable
    fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    )
}

inline fun <reified T : FeatureEntry> Destinations.find(): T =
    findOrNull() ?: error("Unable to find '${T::class.java}' destination.")

inline fun <reified T : FeatureEntry> Destinations.findOrNull(): T? =
    this[T::class.java] as? T
