package org.densis.weather.select_city.presentation

import money.vivid.elmslie.core.store.StateReducer

val SelectCityReducer = object :
    StateReducer<SelectCityEvent, SelectCityState, SelectCityEffect, SelectCityCommand>() {
    override fun StateReducer<SelectCityEvent, SelectCityState, SelectCityEffect, SelectCityCommand>.Result.reduce(
        event: SelectCityEvent
    ) {
        when (event) {
            is SelectCityEvent.OnInitScreen -> {
                commands { +SelectCityCommand.GetCities }
            }

            is SelectCityEvent.OnInputText -> {
                state { copy(text = event.text) }
            }

            is SelectCityEvent.OnShowToast -> {
                state {
                    copy(yourText = "your entetered this text \"${state.text}\"")
                }
            }

            is SelectCityEvent.OnSelectButtonClicked -> {
                effects { +SelectCityEffect.OpenWeatherScreen }
            }
        }
    }
}