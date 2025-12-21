package org.densis.weather.select_city.presentation

sealed class SelectCityCommand {
    object GetCities : SelectCityCommand()
}