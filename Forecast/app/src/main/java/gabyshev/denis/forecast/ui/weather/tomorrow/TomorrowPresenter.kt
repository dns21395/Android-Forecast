package gabyshev.denis.forecast.ui.weather.tomorrow

import android.content.Context
import gabyshev.denis.forecast.data.DataManager
import gabyshev.denis.forecast.data.weather.WeatherManager
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 26/12/2017.
 */
class TomorrowPresenter<V: TomorrowMvpView>
    @Inject constructor(@ActivityContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable,
                        private val weatherManager: WeatherManager)
    : BasePresenter<V>(context, dataManager, compositeDisposable), TomorrowMvpPresenter<V> {

    override fun getTomorrowWeather() {
        mvpView?.updateUI(weatherManager.getTomorrowWeather())
    }
}