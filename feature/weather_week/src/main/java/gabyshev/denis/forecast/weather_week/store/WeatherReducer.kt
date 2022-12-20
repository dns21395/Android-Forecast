package gabyshev.denis.forecast.weather_week.store

import gabyshev.denis.forecast.core.redux.Action

internal fun WeekState.reduce(action: Action): WeekState {
    return when (action) {
        is OnReceivedDaysWeek -> {
            copy(days = action.daysWeek)
        }
        else -> this
    }
}