package org.densis.weather.weather.domain.entity

data class WeatherForecastDay(
    val imageType: WeatherImageType,
    val temperature: String,
)