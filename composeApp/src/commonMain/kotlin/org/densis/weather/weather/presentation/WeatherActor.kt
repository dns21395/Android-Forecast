package org.densis.weather.weather.presentation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import money.vivid.elmslie.core.store.Actor
import org.densis.weather.weather.domain.usecase.GetWeatherUseCase

class WeatherActor(
    private val getWeatherUseCase: GetWeatherUseCase,
) : Actor<WeatherCommand, WeatherEvent>() {

    override fun execute(command: WeatherCommand): Flow<WeatherEvent> {
        return when (command) {
            is WeatherCommand.GetWeather -> flow {
                val weather = getWeatherUseCase.execute()
                emit(WeatherEvent.OnReceivedWeather(weather))
            }
        }
    }
}