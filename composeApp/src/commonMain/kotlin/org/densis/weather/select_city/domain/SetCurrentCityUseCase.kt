package org.densis.weather.select_city.domain

import org.densis.weather.data.WeatherRepository

class SetCurrentCityUseCase(
    val weatherRepository: WeatherRepository
) {

    suspend fun execute(cityName: String) {
        weatherRepository.setCity(cityName)
    }
}