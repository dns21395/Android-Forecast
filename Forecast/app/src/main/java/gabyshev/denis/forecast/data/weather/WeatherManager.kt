package gabyshev.denis.forecast.data.weather

import gabyshev.denis.forecast.weather_api.currentPojo.CurrentPojo
import gabyshev.denis.forecast.weather_api.weekPojo.WeekPojo

/**
 * Created by denis on 26/12/2017.
 */
interface WeatherManager {
    fun setCurrentWeather(current: CurrentPojo)
    fun setTomorrowWeather(weather: WeekPojo)
    fun setWeekWeather(weather: WeekPojo)

    fun getCurrentWeather(): DayWeather?
    fun getTomorrowWeather(): DayWeather?
    fun getWeekWeather(): ArrayList<WeekWeather>

}