package org.densis.weather.select_city.presentation

sealed class SelectCityEvent {
    data class OnInputText(val text: String) : SelectCityEvent()
    object OnSelectButtonClicked : SelectCityEvent()
    object OnSelectFinished : SelectCityEvent()
}