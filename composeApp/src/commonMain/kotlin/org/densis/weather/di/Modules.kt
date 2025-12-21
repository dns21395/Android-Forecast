package org.densis.weather.di

import money.vivid.elmslie.core.store.NoOpActor
import org.densis.weather.select_city.presentation.SelectCityReducer
import org.densis.weather.select_city.presentation.SelectCityState
import org.densis.weather.select_city.presentation.SelectCityStore
import org.koin.dsl.module

val sharedModule = module {
    single {
        fun createStore() = SelectCityStore(
            initialState = SelectCityState(),
            reducer = SelectCityReducer,
            actor = NoOpActor()
        ).start()
    }
}