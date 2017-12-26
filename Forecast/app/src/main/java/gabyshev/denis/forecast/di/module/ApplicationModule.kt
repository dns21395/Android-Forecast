package gabyshev.denis.forecast.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import gabyshev.denis.forecast.data.AppDataManager
import gabyshev.denis.forecast.data.DataManager
import gabyshev.denis.forecast.data.prefs.AppPreferencesHelper
import gabyshev.denis.forecast.data.prefs.PreferencesHelper
import gabyshev.denis.forecast.data.weather.AppWeatherManager
import gabyshev.denis.forecast.data.weather.WeatherManager
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.di.ApplicationContext
import gabyshev.denis.forecast.di.PerActivity
import gabyshev.denis.forecast.di.PreferenceInfo
import gabyshev.denis.forecast.ui.splash.SplashMvpPresenter
import gabyshev.denis.forecast.ui.splash.SplashMvpView
import gabyshev.denis.forecast.ui.splash.SplashPresenter
import gabyshev.denis.forecast.utils.AppConstants
import javax.inject.Singleton

/**
 * Created by Borya on 22.07.2017.
 */
@Module
class ApplicationModule(val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper = appPreferencesHelper

    @Provides
    @Singleton
    fun provideWeatherManager(appWeatherManager: AppWeatherManager): WeatherManager = appWeatherManager



}