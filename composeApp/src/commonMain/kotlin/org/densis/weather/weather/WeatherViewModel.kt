package org.densis.weather.weather

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import org.densis.weather.weather.presentation.WeatherEvent
import org.densis.weather.weather.presentation.WeatherState
import org.densis.weather.weather.presentation.WeatherStore

class WeatherViewModel(
    val store: WeatherStore,
) : ViewModel() {

    val state: StateFlow<WeatherState> = store.states
    val effects = store.effects

    init {
        store.start()

        onEvent(WeatherEvent.InitScreen)
    }

    fun onEvent(event: WeatherEvent) {
        store.accept(event)
    }
}