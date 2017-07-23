package gabyshev.denis.forecast.weather_api

import android.content.Context
import android.util.Log
import gabyshev.denis.forecast.settings.AppPreferences
import gabyshev.denis.forecast.weather_api.currentWeatherPojo.CurrentWeatherPojo
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Borya on 23.07.2017.
 */
class RetrofitWeatherService(val weatherService: WeatherService) {
    private val TAG = "RetroWeather";

    private val APPID = "62401aa21c0e9cef83a8c13f1b85198c"

    fun getCurrentWeather(context: Context) {
        Log.d(TAG, "getCurerntWeather")
        weatherService.getCurrentWeather(AppPreferences.instance()!!.getCity(context).toLong(), APPID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(handleCurrentWeather())
    }

    private fun handleCurrentWeather(): Observer<CurrentWeatherPojo> {
        return object : Observer<CurrentWeatherPojo> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: CurrentWeatherPojo) {
                Log.d(TAG, "response : ${t.name} ${t.clouds}")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "error : ${e.message}")
            }

        }
    }
}