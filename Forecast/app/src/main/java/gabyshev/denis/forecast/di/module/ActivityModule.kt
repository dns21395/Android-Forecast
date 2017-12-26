package gabyshev.denis.forecast.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.data.city_list.AppCityManager
import gabyshev.denis.forecast.data.city_list.CityManager
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.di.PerActivity
import gabyshev.denis.forecast.ui.city.SelectCityAdapter
import gabyshev.denis.forecast.ui.city.SelectCityMvpPresenter
import gabyshev.denis.forecast.ui.city.SelectCityMvpView
import gabyshev.denis.forecast.ui.city.SelectCityPresenter
import gabyshev.denis.forecast.ui.city.result.ResultCityAdapter
import gabyshev.denis.forecast.ui.city.result.ResultCityMvpPresenter
import gabyshev.denis.forecast.ui.city.result.ResultCityMvpView
import gabyshev.denis.forecast.ui.city.result.ResultCityPresenter
import gabyshev.denis.forecast.ui.city.search.SearchCityMvpPresenter
import gabyshev.denis.forecast.ui.city.search.SearchCityMvpView
import gabyshev.denis.forecast.ui.city.search.SearchCityPresenter
import gabyshev.denis.forecast.ui.splash.SplashMvpPresenter
import gabyshev.denis.forecast.ui.splash.SplashMvpView
import gabyshev.denis.forecast.ui.splash.SplashPresenter
import gabyshev.denis.forecast.ui.weather.WeatherAdapter
import gabyshev.denis.forecast.ui.weather.WeatherMvpPresenter
import gabyshev.denis.forecast.ui.weather.WeatherMvpView
import gabyshev.denis.forecast.ui.weather.WeatherPresenter
import gabyshev.denis.forecast.ui.weather.current.CurrentMvpPresenter
import gabyshev.denis.forecast.ui.weather.current.CurrentMvpView
import gabyshev.denis.forecast.ui.weather.current.CurrentPresenter
import gabyshev.denis.forecast.ui.weather.tomorrow.TomorrowMvpPresenter
import gabyshev.denis.forecast.ui.weather.tomorrow.TomorrowMvpView
import gabyshev.denis.forecast.ui.weather.tomorrow.TomorrowPresenter
import gabyshev.denis.forecast.ui.weather.week.WeekAdapter
import gabyshev.denis.forecast.ui.weather.week.WeekMvpPresenter
import gabyshev.denis.forecast.ui.weather.week.WeekMvpView
import gabyshev.denis.forecast.ui.weather.week.WeekPresenter
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by denis on 22/12/2017.
 */
@Module
class ActivityModule(val activity: AppCompatActivity) {
    @Provides
    @ActivityContext
    fun provideContext(): Context = activity

    @Provides
    fun provideActivity(): AppCompatActivity = activity

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideCityManager(appCityManager: AppCityManager): CityManager = appCityManager

    @Provides
    fun provideLinearLayoutManager(@ActivityContext context: Context): LinearLayoutManager = LinearLayoutManager(context)

    // Activity

    @Provides
    @PerActivity
    fun provideSplashPresenter(presenter: SplashPresenter<SplashMvpView>): SplashMvpPresenter<SplashMvpView> = presenter

    @Provides
    @PerActivity
    fun provideSelectCityPresenter(presenter: SelectCityPresenter<SelectCityMvpView>): SelectCityMvpPresenter<SelectCityMvpView> = presenter

    @Provides
    @PerActivity
    fun provideWeatherPresenter(presenter: WeatherPresenter<WeatherMvpView>): WeatherMvpPresenter<WeatherMvpView> = presenter

    // Fragment

    @Provides
    fun provideSearchCityPresenter(presenter: SearchCityPresenter<SearchCityMvpView>): SearchCityMvpPresenter<SearchCityMvpView> = presenter

    @Provides
    fun provideResultCityPresenter(presenter: ResultCityPresenter<ResultCityMvpView>): ResultCityMvpPresenter<ResultCityMvpView> = presenter

    @Provides
    fun provideCurrentPresenter(presenter: CurrentPresenter<CurrentMvpView>): CurrentMvpPresenter<CurrentMvpView> = presenter

    @Provides
    fun provideTomorrowPresenter(presenter: TomorrowPresenter<TomorrowMvpView>): TomorrowMvpPresenter<TomorrowMvpView> = presenter

    @Provides
    fun provideWeekPresenter(presenter: WeekPresenter<WeekMvpView>): WeekMvpPresenter<WeekMvpView> = presenter

    // Adapter
    @Provides
    @PerActivity
    fun provideResultCityAdapter(@ActivityContext context: Context): ResultCityAdapter = ResultCityAdapter(context)

    @Provides
    fun provideSelectCityAdapter(activity: AppCompatActivity): SelectCityAdapter = SelectCityAdapter(activity.supportFragmentManager)

    @Provides
    fun weatherAdapter(activity: AppCompatActivity): WeatherAdapter = WeatherAdapter(activity.supportFragmentManager)

    @Provides
    fun weekAdapter(@ActivityContext context: Context): WeekAdapter = WeekAdapter(context)

}