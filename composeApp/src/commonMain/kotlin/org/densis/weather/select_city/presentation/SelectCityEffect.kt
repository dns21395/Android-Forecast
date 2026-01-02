package org.densis.weather.select_city.presentation

sealed class SelectCityEffect {
    object OpenWeatherScreen : SelectCityEffect()
}