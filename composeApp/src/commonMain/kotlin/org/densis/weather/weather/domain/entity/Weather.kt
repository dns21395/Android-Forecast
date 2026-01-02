package org.densis.weather.weather.domain.entity

data class Weather(
    val cityName: String,
    val temperature: String,
    val imageType: WeatherImageType,
    val description: String,
    val weeklyForecast: List<WeatherForecastDay>,
)