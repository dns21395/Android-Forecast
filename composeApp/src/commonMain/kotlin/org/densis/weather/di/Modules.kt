package org.densis.weather.di

import money.vivid.elmslie.core.store.NoOpActor
import org.densis.weather.select_city.SelectCityViewModel
import org.densis.weather.select_city.presentation.SelectCityReducer
import org.densis.weather.select_city.presentation.SelectCityState
import org.densis.weather.select_city.presentation.SelectCityStore
import org.densis.weather.weather.WeatherViewModel
import org.densis.weather.weather.presentation.WeatherActor
import org.densis.weather.weather.presentation.WeatherReducer
import org.densis.weather.weather.presentation.WeatherState
import org.densis.weather.weather.presentation.WeatherStore
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    factory(named("select_city")) {
        SelectCityStore(
            initialState = SelectCityState(),
            reducer = SelectCityReducer,
            actor = NoOpActor()
        )
    }

    factory(named("weather")) {
        WeatherStore(
            initialState = WeatherState(),
            reducer = WeatherReducer,
            actor = WeatherActor(get())
        )
    }

    viewModel { SelectCityViewModel(get(named("select_city")), get()) }
    viewModel { WeatherViewModel(get(named("weather"))) }
}