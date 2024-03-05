package gabyshev.denis.forecast

import com.github.terrakok.modo.Screen
import gabyshev.denis.forecast.core.common.FeatureScreens
import gabyshev.denis.forecast.feature.weather.WeatherStack

internal class FeatureScreensImpl : FeatureScreens {
    override fun getWeatherScreen(): Screen = WeatherStack()
}