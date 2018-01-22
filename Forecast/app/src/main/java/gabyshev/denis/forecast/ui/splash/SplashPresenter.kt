package gabyshev.denis.forecast.ui.splash

import android.content.Context
import android.util.Log
import gabyshev.denis.forecast.data.DataManager
import gabyshev.denis.forecast.data.network.RetrofitWeatherService
import gabyshev.denis.forecast.data.weather.WeatherManager
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by denis on 24/12/2017.
 */
class SplashPresenter<V: SplashMvpView>
    @Inject constructor(@ActivityContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable,
                        private val weatherManager: WeatherManager,
                        private val retrofitWeatherService: RetrofitWeatherService)
    : BasePresenter<V>(context, dataManager, compositeDisposable), SplashMvpPresenter<V> {
    private val TAG = "SplashPresenter"

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

        when(dataManager.getCity()) {
            -1L -> mvpView.openSelectCityActivity()
            else -> {
                var countSuccessOperations = 0
                val observableCurrentWeather = retrofitWeatherService.getCurrentWeather()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext {
                            weatherManager.setCurrentWeather(it)
                        }

                val observableTomorrowWeekWeather = retrofitWeatherService.getWeekWeather()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext {
                            weatherManager.setTomorrowWeather(it)
                            weatherManager.setWeekWeather(it)
                        }
                compositeDisposable.add(
                        Observable.concat(observableCurrentWeather, observableTomorrowWeekWeather)
                                .subscribe {
                                    countSuccessOperations++
                                    if(countSuccessOperations == 2) mvpView.openWeatherActivity()
                                }
                )

            }
        }
    }
}