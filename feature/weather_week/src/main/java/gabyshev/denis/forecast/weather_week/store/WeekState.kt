package gabyshev.denis.forecast.weather_week.store

import gabyshev.denis.forecast.weather_week.domain.entity.DayWeather

internal data class WeekState(
    val days: List<DayWeather> = emptyList()
)