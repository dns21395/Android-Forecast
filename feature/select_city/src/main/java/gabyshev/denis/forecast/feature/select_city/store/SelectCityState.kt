package gabyshev.denis.forecast.feature.select_city.store

import gabyshev.denis.forecast.core.data.api.entity.City
import gabyshev.denis.forecast.feature.select_city.domain.entity.ScreenType

data class SelectCityState(
    val cityId: Int = -1,
    val currentScreen: ScreenType = ScreenType.SEARCH_CITY,
    val cities: List<City> = emptyList()
)
