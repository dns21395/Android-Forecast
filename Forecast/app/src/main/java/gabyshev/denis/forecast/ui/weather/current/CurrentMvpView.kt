package gabyshev.denis.forecast.ui.weather.current

import gabyshev.denis.forecast.data.weather.DayWeather
import gabyshev.denis.forecast.ui.base.MvpView

/**
 * Created by denis on 26/12/2017.
 */
interface CurrentMvpView : MvpView {
    fun updateUI(currentWeather: DayWeather?)
}