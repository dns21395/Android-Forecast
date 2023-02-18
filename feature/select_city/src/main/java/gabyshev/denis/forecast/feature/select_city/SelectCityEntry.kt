package gabyshev.denis.forecast.feature.select_city

import gabyshev.denis.forecast.core.common.ComposableFeatureEntry

abstract class SelectCityEntry : ComposableFeatureEntry {

    override val featureRoute: String = "select_city"

    fun destination() = featureRoute
}