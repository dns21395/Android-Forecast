package org.densis.weather.weather.domain.entity

data class WeatherForecastDay(
    val imageType: WeatherImageType,
    val dayName: String,
    val temperature: String,
)