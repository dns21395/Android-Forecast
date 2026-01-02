package org.densis.weather.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.densis.weather.weather.domain.entity.Weather
import org.densis.weather.weather.domain.entity.WeatherForecastDay
import org.densis.weather.weather.domain.entity.WeatherImageType
import kotlin.random.Random

class WeatherRepository(
    val dataStore: DataStore<Preferences>,
) {

    companion object {
        private val NAME_KEY = stringPreferencesKey(("city"))
    }

    suspend fun setCity(cityName: String) {
        dataStore.updateData {
            it.toMutablePreferences().also { preferences ->
                preferences[NAME_KEY] = cityName
            }
        }
    }

    suspend fun getWeather(): Weather {
        val cityName = getCityName()
        val forecast = getCurrentWeather().random()

        return Weather(
            cityName = cityName,
            temperature = "${Random.nextInt(25) - Random.nextInt(25)}°",
            imageType = forecast.first,
            description = forecast.second,
            weeklyForecast = getWeeklyForecast()
        )

    }

    private suspend fun getCityName(): String {
        return dataStore.data.map { preferences ->
            preferences[NAME_KEY] ?: ""
        }.first()
    }

    private fun getWeeklyForecast(): List<WeatherForecastDay> {
        val list = arrayListOf<WeatherForecastDay>()

        val daysName = listOf(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        )

        for (i in 0 until 7) {
            val day = "${Random.Default.nextInt(25) - Random.Default.nextInt(10)}°"
            val night = "${Random.Default.nextInt(25) - Random.Default.nextInt(10)}°"

            list.add(
                WeatherForecastDay(
                    imageType = WeatherImageType.entries.toTypedArray().random(),
                    dayName = daysName[i],
                    temperature = "$day / $night",
                )
            )
        }

        return list
    }

    private fun getCurrentWeather(): List<Pair<WeatherImageType, String>> {
        return listOf(
            WeatherImageType.CLEAR_SKY to "Clear Sky",
            WeatherImageType.CLEAR_SKY_NIGHT to "Clear Sky",
            WeatherImageType.FEW_CLOUDS to "Few Clouds",
            WeatherImageType.FEW_CLOUDS_NIGHT to "Few Clouds",
            WeatherImageType.RAIN to "Rain",
            WeatherImageType.RAIN_NIGHT to "Rain",
            WeatherImageType.MIST to "Mist",
            WeatherImageType.SHOWER_RAIN to "Shower Rain",
            WeatherImageType.SNOW to "Snow",
            WeatherImageType.THUNDERSTORM to "Thunderstorm",
        )
    }
}