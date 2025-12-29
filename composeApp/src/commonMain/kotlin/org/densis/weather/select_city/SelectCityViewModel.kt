package org.densis.weather.select_city

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.densis.weather.select_city.presentation.SelectCityEvent
import org.densis.weather.select_city.presentation.SelectCityState
import org.densis.weather.select_city.presentation.SelectCityStore

class SelectCityViewModel(
    val store: SelectCityStore,
    val dataStore: DataStore<Preferences>,
) : ViewModel() {

    companion object {
        private val NAME_KEY = stringPreferencesKey(("city"))
    }

    init {
        store.start()
    }

    val state: StateFlow<SelectCityState> = store.states
    val effects = store.effects

    fun onEvent(event: SelectCityEvent) {
        if (event is SelectCityEvent.OnInputText) {
            viewModelScope.launch(Dispatchers.IO) {
                dataStore.updateData {
                    it.toMutablePreferences().also { preferences ->
                        preferences[NAME_KEY] = event.text
                    }
                }
            }
        }

        store.accept(event)
    }
}