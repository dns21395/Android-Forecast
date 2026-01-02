package org.densis.weather.weather.presentation

import money.vivid.elmslie.core.store.StateReducer

val WeatherReducer =
    object : StateReducer<WeatherEvent, WeatherState, WeatherEffect, WeatherCommand>() {
        override fun StateReducer<WeatherEvent, WeatherState, WeatherEffect, WeatherCommand>.Result.reduce(
            event: WeatherEvent
        ) {
            when (event) {
                is WeatherEvent.InitScreen -> {
                    commands {
                        +WeatherCommand.GetCityName
                    }
                }

                is WeatherEvent.OnReceivedCityName -> {
                    state { copy(cityName = event.cityName) }
                }

                else -> {}
            }
        }
    }