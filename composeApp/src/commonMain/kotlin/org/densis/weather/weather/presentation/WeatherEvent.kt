package org.densis.weather.weather.presentation

import org.densis.weather.weather.domain.entity.Weather

sealed class WeatherEvent {
    data object InitScreen : WeatherEvent()
    data class OnReceivedWeather(val weather: Weather) : WeatherEvent()
}