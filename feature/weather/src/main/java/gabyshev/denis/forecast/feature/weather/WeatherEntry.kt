package gabyshev.denis.forecast.feature.weather

import gabyshev.denis.forecast.core.common.ComposableFeatureEntry

abstract class WeatherEntry : ComposableFeatureEntry {

    override val featureRoute: String = "weather"

    fun destination() = featureRoute
}