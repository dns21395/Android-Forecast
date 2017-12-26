package gabyshev.denis.forecast.ui.weather.tomorrow

import gabyshev.denis.forecast.data.weather.DayWeather
import gabyshev.denis.forecast.ui.base.MvpView

/**
 * Created by denis on 26/12/2017.
 */
interface TomorrowMvpView : MvpView {
    fun updateUI(tomorrowWeather: DayWeather?)
}