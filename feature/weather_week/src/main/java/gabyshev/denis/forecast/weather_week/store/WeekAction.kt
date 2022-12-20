package gabyshev.denis.forecast.weather_week.store

import gabyshev.denis.forecast.core.data.api.entity.Day
import gabyshev.denis.forecast.core.redux.Action

internal object InitWeekScreen : Action

internal data class OnReceivedDaysWeek(val daysWeek: List<Day>) : Action