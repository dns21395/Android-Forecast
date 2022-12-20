package gabyshev.denis.forecast.weather_week.store

import gabyshev.denis.forecast.core.data.api.entity.Day

internal data class WeekState(
    val days: List<Day> = emptyList()
)