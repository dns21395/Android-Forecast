package gabyshev.denis.forecast.ui.weather.week

import gabyshev.denis.forecast.ui.base.MvpPresenter

/**
 * Created by denis on 26/12/2017.
 */
interface WeekMvpPresenter<V : WeekMvpView> : MvpPresenter<V> {
    fun getWeekWeather()
}