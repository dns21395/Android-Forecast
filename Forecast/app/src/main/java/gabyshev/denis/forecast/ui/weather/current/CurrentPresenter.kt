package gabyshev.denis.forecast.ui.weather.current

import android.content.Context
import gabyshev.denis.forecast.data.DataManager
import gabyshev.denis.forecast.data.network.RetrofitWeatherService
import gabyshev.denis.forecast.data.weather.WeatherManager
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by denis on 26/12/2017.
 */
class CurrentPresenter<V : CurrentMvpView>
    @Inject constructor(@ActivityContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable,
                        private val weatherManager: WeatherManager)
    : BasePresenter<V>(context, dataManager, compositeDisposable), CurrentMvpPresenter<V> {

    private val TAG = "CurrentPresenter"


    override fun getTodayWeather() {
        mvpView?.updateUI(weatherManager.getCurrentWeather())

    }
}