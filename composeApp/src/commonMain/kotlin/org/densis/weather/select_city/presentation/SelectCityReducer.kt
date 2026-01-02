package org.densis.weather.select_city.presentation

import money.vivid.elmslie.core.store.StateReducer

val SelectCityReducer = object :
    StateReducer<SelectCityEvent, SelectCityState, SelectCityEffect, SelectCityCommand>() {
    override fun StateReducer<SelectCityEvent, SelectCityState, SelectCityEffect, SelectCityCommand>.Result.reduce(
        event: SelectCityEvent
    ) {
        when (event) {
            is SelectCityEvent.OnInputText -> {
                state { copy(cityName = event.text) }
            }

            is SelectCityEvent.OnSelectButtonClicked -> {
                commands { +SelectCityCommand.SetCurrentCity(state.cityName) }
            }

            is SelectCityEvent.OnSelectFinished -> {
                effects { +SelectCityEffect.OpenWeatherScreen }
            }
        }
    }
}