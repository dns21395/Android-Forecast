package org.densis.weather.weather.data.repository

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

        for (i in 0 until 7) {
            val day = "${Random.nextInt(25) - Random.nextInt(25)}°"
            val night = "${Random.nextInt(25) - Random.nextInt(25)}°"

            list.add(
                WeatherForecastDay(
                    imageType = WeatherImageType.entries.toTypedArray().random(),
                    temperature = "$day / $night",
                )
            )
        }

        return list
    }

    private fun getCurrentWeather(): List<Pair<WeatherImageType, String>> {
        return listOf(
            WeatherImageType.CLEAR_SKY to "CLEAR SKY",
            WeatherImageType.CLEAR_SKY_NIGHT to "CLEAR SKY",
            WeatherImageType.FEW_CLOUDS to "FEW CLOUDS",
            WeatherImageType.FEW_CLOUDS_NIGHT to "FEW CLOUDS",
            WeatherImageType.RAIN to "RAIN",
            WeatherImageType.RAIN_NIGHT to "RAIN",
            WeatherImageType.MIST to "MIST",
            WeatherImageType.SHOWER_RAIN to "SHOWER RAIN",
            WeatherImageType.SNOW to "SNOW",
            WeatherImageType.THUNDERSTORM to "THUNDERSTORM",
        )
    }
}