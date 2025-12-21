package org.densis.weather.select_city

import androidx.lifecycle.ViewModel
import org.densis.weather.select_city.presentation.SelectCityEvent
import org.densis.weather.select_city.presentation.SelectCityStore

class SelectCityViewModel(val store: SelectCityStore) : ViewModel() {

    init {
        store.start()
    }

    val state = store.states
    val effects = store.effects

    fun onEvent(event: SelectCityEvent) {
        store.accept(event)
    }
}