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
                        +WeatherCommand.GetWeather
                    }
                }

                is WeatherEvent.OnReceivedWeather -> {
                    val weather = event.weather
                    state {
                        copy(
                            cityName = weather.cityName,
                            temperature = weather.temperature,
                            imageType = weather.imageType,
                            description = weather.description,
                            forecast = weather.weeklyForecast,
                        )
                    }
                }

                else -> {}
            }
        }
    }