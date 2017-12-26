package gabyshev.denis.forecast.data.network

import android.util.Log
import gabyshev.denis.forecast.data.prefs.PreferencesHelper
import gabyshev.denis.forecast.weather_api.currentPojo.CurrentPojo
import gabyshev.denis.forecast.weather_api.weekPojo.WeekPojo
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Borya on 23.07.2017.
 */
class RetrofitWeatherService(private val weatherService: WeatherService, private val preferencesHelper: PreferencesHelper) {
    private val APPID = "62401aa21c0e9cef83a8c13f1b85198c"

    fun getCurrentWeather(): Observable<CurrentPojo> =
         weatherService.getCurrentWeather(preferencesHelper.getCity(), APPID, "metric")

    fun getWeekWeather(): Observable<WeekPojo> =
         weatherService.getWeekWeather(preferencesHelper.getCity(), APPID, "metric", 7)

}


