package gabyshev.denis.forecast.feature.select_city.store

import gabyshev.denis.forecast.core.data.api.entity.City
import gabyshev.denis.forecast.core.redux.Action

data class OnCityNameEntered(val cityName: String) : Action

data class OnCitiesFound(val cities: List<City>) : Action

data class OnCityClicked(val city: City) : Action