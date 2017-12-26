package gabyshev.denis.forecast.ui.weather.week

import gabyshev.denis.forecast.data.weather.WeekWeather
import gabyshev.denis.forecast.ui.base.MvpView
import gabyshev.denis.forecast.weather_api.weekPojo.WeekPojo

/**
 * Created by denis on 26/12/2017.
 */
interface WeekMvpView : MvpView {
    fun setRecyclerView(days: ArrayList<WeekWeather>)
}