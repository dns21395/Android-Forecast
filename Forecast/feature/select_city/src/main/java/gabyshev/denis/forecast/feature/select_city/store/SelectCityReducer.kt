package gabyshev.denis.forecast.feature.select_city.store

import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.feature.select_city.domain.entity.ScreenType

internal fun SelectCityState.reduce(action: Action): SelectCityState {
    return when (action) {
        is OnCitiesFound -> copy(
            currentScreen = ScreenType.FOUND_CITIES,
            cities = action.cities
        )
        else -> this
    }
}