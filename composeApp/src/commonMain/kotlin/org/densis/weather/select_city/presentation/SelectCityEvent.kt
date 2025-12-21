package org.densis.weather.select_city.presentation

sealed class SelectCityEvent {
    object OnInitScreen : SelectCityEvent()
}