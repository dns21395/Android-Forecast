package gabyshev.denis.forecast

import android.app.Application
import gabyshev.denis.forecast.injection.AppComponent
import gabyshev.denis.forecast.injection.AppModule
import gabyshev.denis.forecast.injection.DaggerAppComponent

/**
 * Created by Borya on 22.07.2017.
 */

class App : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}
