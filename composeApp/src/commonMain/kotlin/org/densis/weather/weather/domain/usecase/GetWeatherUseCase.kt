package org.densis.weather.weather.domain.usecase

import org.densis.weather.data.WeatherRepository
import org.densis.weather.weather.domain.entity.Weather

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository,
) {

    suspend fun execute(): Weather {
        return weatherRepository.getWeather()
    }
}