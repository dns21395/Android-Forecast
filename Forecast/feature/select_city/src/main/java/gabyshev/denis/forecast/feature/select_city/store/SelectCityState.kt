package gabyshev.denis.forecast.feature.select_city.store

import gabyshev.denis.forecast.feature.select_city.entity.ScreenType

data class SelectCityState(
    val cityId: Int = -1,
    val currentScreen: ScreenType = ScreenType.SEARCH_CITY
)
