package org.densis.weather.select_city

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.densis.weather.data.AppLogger
import org.densis.weather.select_city.presentation.SelectCityEvent
import org.densis.weather.select_city.presentation.SelectCityStore

class SelectCityViewModel(
    val store: SelectCityStore,
    val dataStore: DataStore<Preferences>,
    val appLogger: AppLogger
) : ViewModel() {

    companion object {
        private val NAME_KEY = stringPreferencesKey(("city"))
    }

    init {
        store.start()

        viewModelScope.launch(Dispatchers.IO) {
            dataStore.data.map { preferences ->
                preferences[NAME_KEY] ?: ""
            }
                .collect {
                    appLogger.d("GTA5", "preferences : ${it}")

                }
        }


    }

    val state = store.states
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