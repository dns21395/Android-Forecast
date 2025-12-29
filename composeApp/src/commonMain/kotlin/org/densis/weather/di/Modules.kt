package org.densis.weather.di

import money.vivid.elmslie.core.store.NoOpActor
import org.densis.weather.select_city.SelectCityViewModel
import org.densis.weather.select_city.presentation.SelectCityReducer
import org.densis.weather.select_city.presentation.SelectCityState
import org.densis.weather.select_city.presentation.SelectCityStore
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single {
        SelectCityStore(
            initialState = SelectCityState(),
            reducer = SelectCityReducer,
            actor = NoOpActor()
        )
    }

    viewModel { SelectCityViewModel(get(), get(), get()) }
}