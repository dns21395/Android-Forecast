package org.densis.weather.weather.presentation

sealed class WeatherEvent {
    data object InitScreen : WeatherEvent()
    data class OnReceivedCityName(val cityName: String) : WeatherEvent()
}