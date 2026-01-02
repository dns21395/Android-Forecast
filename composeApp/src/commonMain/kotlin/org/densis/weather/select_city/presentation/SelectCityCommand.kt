package org.densis.weather.select_city.presentation

sealed class SelectCityCommand {
    data class SetCurrentCity(val cityName: String) : SelectCityCommand()
}