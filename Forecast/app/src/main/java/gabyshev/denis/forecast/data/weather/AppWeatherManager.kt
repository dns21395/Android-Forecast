package gabyshev.denis.forecast.data.weather

import gabyshev.denis.forecast.utils.CommonUtils
import gabyshev.denis.forecast.utils.WeatherImageUtils
import gabyshev.denis.forecast.weather_api.currentPojo.CurrentPojo
import gabyshev.denis.forecast.weather_api.weekPojo.WeekPojo
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by denis on 26/12/2017.
 */
@Singleton
class AppWeatherManager @Inject constructor(): WeatherManager {
    private var currentWeather: DayWeather? = null
    private var tomorrowWeather: DayWeather? = null
    private var weekWeather = ArrayList<WeekWeather>()

    override fun setCurrentWeather(current: CurrentPojo) {
        currentWeather = DayWeather(current.name,
                            "${current.main?.temp?.toInt()}\u2103",
                                         current.weather!![0].description!!.toUpperCase(),
                                        WeatherImageUtils.getDrawable(current.weather!![0].icon))
    }

    override fun setTomorrowWeather(weather: WeekPojo) {
        tomorrowWeather = DayWeather(
                weather.city?.name,
                "${weather.list!![0].temp?.day?.toInt()}\u2103",
                weather.list!![0].weather!![0].description?.toUpperCase(),
                WeatherImageUtils.getDrawable(weather.list!![0].weather!![0].icon)
        )
    }

    override fun setWeekWeather(weather: WeekPojo) {
        weekWeather.clear()
        for(day in weather.list!!) {
            weekWeather.add(WeekWeather(
                    CommonUtils.convertDayFromCalendar(weekWeather.size),
                    "${day.temp?.max?.toInt()}\u00B0/${day.temp?.min?.toInt()}\u00B0",
                    WeatherImageUtils.getDrawable(day.weather!![0].icon)))

        }
    }

    override fun getCurrentWeather(): DayWeather? = currentWeather

    override fun getTomorrowWeather(): DayWeather? = tomorrowWeather

    override fun getWeekWeather(): ArrayList<WeekWeather> = weekWeather


}

data class DayWeather(
        val city: String? = "NO CITY",
        val temperature: String? = "NO TEMPERATURE",
        val description: String? = "NO DESCRIPTION",
        val drawable: Int? = null)

data class WeekWeather(
        val day: String? = "NO DAY",
        val temperature: String? = "NO TEMPERATURE",
        val drawable: Int? = null)



