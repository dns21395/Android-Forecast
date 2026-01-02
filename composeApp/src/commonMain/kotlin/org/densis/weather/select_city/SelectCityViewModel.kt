package org.densis.weather.select_city

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import org.densis.weather.select_city.presentation.SelectCityEvent
import org.densis.weather.select_city.presentation.SelectCityState
import org.densis.weather.select_city.presentation.SelectCityStore

class SelectCityViewModel(
    val store: SelectCityStore,
) : ViewModel() {

    init {
        store.start()
    }

    val state: StateFlow<SelectCityState> = store.states
    val effects = store.effects

    fun onEvent(event: SelectCityEvent) {
        store.accept(event)
    }
}