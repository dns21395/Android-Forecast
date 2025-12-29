package org.densis.weather.weather.presentation

import money.vivid.elmslie.core.store.ElmStore

typealias WeatherStore = ElmStore<
        WeatherEvent,
        WeatherState,
        WeatherEffect,
        WeatherCommand>