package org.densis.weather.weather

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import org.densis.weather.weather.presentation.WeatherEvent
import org.densis.weather.weather.presentation.WeatherState
import org.densis.weather.weather.presentation.WeatherStore

class WeatherViewModel(
    val store: WeatherStore,
    val dataStore: DataStore<Preferences>,
) : ViewModel() {

    val state: StateFlow<WeatherState> = store.states
    val effects = store.effects

    init {
        store.start()
    }

    fun onEvent(event: WeatherEvent) {

    }
}