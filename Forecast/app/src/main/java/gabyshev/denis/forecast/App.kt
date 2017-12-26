package gabyshev.denis.forecast

import android.app.Application
import gabyshev.denis.forecast.di.component.ApplicationComponent
import gabyshev.denis.forecast.di.component.DaggerApplicationComponent
import gabyshev.denis.forecast.di.module.ApplicationModule
import gabyshev.denis.forecast.di.module.NetworkModule


/**
 * Created by Borya on 22.07.2017.
 */

class App : Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)
    }

}
