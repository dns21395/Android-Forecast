package gabyshev.denis.forecast.feature.weather.store

import gabyshev.denis.forecast.core.redux.Action

internal fun WeatherState.reduce(action: Action): WeatherState {
    return when (action) {
        else -> this
    }
}