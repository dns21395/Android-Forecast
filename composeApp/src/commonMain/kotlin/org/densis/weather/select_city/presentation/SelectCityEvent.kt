package org.densis.weather.select_city.presentation

sealed class SelectCityEvent {
    object OnInitScreen : SelectCityEvent()
    data class OnInputText(val text: String) : SelectCityEvent()
    object OnShowToast : SelectCityEvent()
    object OnSelectButtonClicked : SelectCityEvent()
}