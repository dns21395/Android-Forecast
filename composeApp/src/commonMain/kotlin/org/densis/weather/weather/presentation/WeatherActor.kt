package org.densis.weather.weather.presentation

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import money.vivid.elmslie.core.store.Actor

class WeatherActor(
    val dataStore: DataStore<Preferences>,
) : Actor<WeatherCommand, WeatherEvent>() {

    companion object {
        private val NAME_KEY = stringPreferencesKey(("city"))
    }

    override fun execute(command: WeatherCommand): Flow<WeatherEvent> {
        return when (command) {
            is WeatherCommand.GetCityName -> {
                dataStore.data.map { preferences ->
                    WeatherEvent.OnReceivedCityName(preferences[NAME_KEY] ?: "")
                }.take(1)
            }
        }
    }
}