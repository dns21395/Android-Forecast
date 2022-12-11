package gabyshev.denis.forecast.core.data.domain.interactor

import gabyshev.denis.forecast.core.data.api.WeatherApi
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherApi: WeatherApi,
) {
    suspend fun getWeather() = weatherApi.getWeatherData()
}