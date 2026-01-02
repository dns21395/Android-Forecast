package org.densis.weather.weather.presentation

sealed class WeatherCommand {
    object GetWeather : WeatherCommand()
}