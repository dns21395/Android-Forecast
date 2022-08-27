package gabyshev.denis.forecast.feature.select_city.store

import gabyshev.denis.forecast.core.redux.Action

data class OnCityNameEntered(val cityName: String) : Action

object OnCitiesFound : Action