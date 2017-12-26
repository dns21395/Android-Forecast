package gabyshev.denis.forecast.ui.weather

import android.content.Context
import gabyshev.denis.forecast.data.DataManager
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.ui.base.BasePresenter
import gabyshev.denis.forecast.ui.base.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by denis on 26/12/2017.
 */
class WeatherPresenter<V: WeatherMvpView>
    @Inject constructor(@ActivityContext context: Context,
                        dataManager: DataManager,
                        compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(context, dataManager, compositeDisposable), WeatherMvpPresenter<V>{
}