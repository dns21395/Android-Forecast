package gabyshev.denis.forecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import gabyshev.denis.forecast.core.data.di.DaggerDataComponent
import gabyshev.denis.forecast.core.di.ApplicationApi
import gabyshev.denis.forecast.di.AppModule
import gabyshev.denis.forecast.di.DaggerAppComponent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val coreProvider = (applicationContext as ApplicationApi).coreProvider()
        DaggerDataComponent.factory().create(coreProvider).cityApi()
    }
}