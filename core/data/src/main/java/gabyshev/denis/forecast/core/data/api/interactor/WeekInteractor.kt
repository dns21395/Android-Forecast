package gabyshev.denis.forecast.core.data.api.interactor

import gabyshev.denis.forecast.core.data.api.entity.Day

interface WeekInteractor {
    suspend fun getWeekWeather(): List<Day>
}