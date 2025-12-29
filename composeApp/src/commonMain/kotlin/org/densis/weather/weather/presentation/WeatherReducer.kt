package org.densis.weather.weather.presentation

import money.vivid.elmslie.core.store.StateReducer

val WeatherReducer =
    object : StateReducer<WeatherEvent, WeatherState, WeatherEffect, WeatherCommand>() {
        override fun StateReducer<WeatherEvent, WeatherState, WeatherEffect, WeatherCommand>.Result.reduce(
            event: WeatherEvent
        ) {

        }
    }