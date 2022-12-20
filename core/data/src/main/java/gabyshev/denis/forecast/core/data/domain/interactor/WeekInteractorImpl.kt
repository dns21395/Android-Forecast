package gabyshev.denis.forecast.core.data.domain.interactor

import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.WeatherApi
import gabyshev.denis.forecast.core.data.api.entity.Day
import gabyshev.denis.forecast.core.data.api.interactor.WeekInteractor
import gabyshev.denis.forecast.core.data.data.dto.mapper.toDomain
import javax.inject.Inject

internal class WeekInteractorImpl @Inject constructor(
    private val cityApi: CityApi,
    private val weatherApi: WeatherApi,
) : WeekInteractor {

    override suspend fun getWeekWeather(): List<Day> {
        val location = cityApi.getSelectedCity().location
        val daysWeather =
            weatherApi.getWeekData(latitude = location.latitude, longitude = location.longitude)

        return daysWeather.daily.toDomain()
    }
}