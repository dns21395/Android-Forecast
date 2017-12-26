package gabyshev.denis.forecast.di.component

import dagger.Component
import gabyshev.denis.forecast.di.PerActivity
import gabyshev.denis.forecast.di.module.ActivityModule
import gabyshev.denis.forecast.ui.city.SelectCityActivity
import gabyshev.denis.forecast.ui.city.result.ResultCityFragment
import gabyshev.denis.forecast.ui.city.search.SearchCityFragment
import gabyshev.denis.forecast.ui.splash.SplashActivity
import gabyshev.denis.forecast.ui.weather.WeatherActivity
import gabyshev.denis.forecast.ui.weather.current.CurrentFragment
import gabyshev.denis.forecast.ui.weather.tomorrow.TomorrowFragment
import gabyshev.denis.forecast.ui.weather.week.WeekFragment

/**
 * Created by denis on 22/12/2017.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    // Activity
    fun inject(splashActivity: SplashActivity)
    fun inject(selectCityActivity: SelectCityActivity)
    fun inject(weatherActivity: WeatherActivity)

    // Fragment
    fun inject(resultCityFragment: ResultCityFragment)
    fun inject(searchCityFragment: SearchCityFragment)
    fun inject(currentFragment: CurrentFragment)
    fun inject(tomorrowFragment: TomorrowFragment)
    fun inject(weekFragment: WeekFragment)
}