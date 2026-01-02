package org.densis.weather.weather.presentation

import org.densis.weather.weather.domain.entity.WeatherForecastDay
import org.densis.weather.weather.domain.entity.WeatherImageType

data class WeatherState(
    val cityName: String = "",
    val temperature: String = "",
    val imageType: WeatherImageType = WeatherImageType.THUNDERSTORM,
    val description: String = "",
    val forecast: List<WeatherForecastDay> = emptyList(),
)