package gabyshev.denis.forecast.feature.weather.di

import androidx.compose.runtime.staticCompositionLocalOf
import gabyshev.denis.forecast.core.navigation.Navigation

interface WeatherDependencies {
    @WeatherNavigationQualifier
    fun navigation(): Navigation
}

val LocalWeatherDependenciesProvider = staticCompositionLocalOf<WeatherDependencies> {
    error("FeatureDependencies not found")
}
