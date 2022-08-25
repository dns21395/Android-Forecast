package gabyshev.denis.forecast

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import gabyshev.denis.forecast.core.data.di.DaggerDataComponent
import gabyshev.denis.forecast.core.di.ApplicationApi

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val coreProvider = (applicationContext as ApplicationApi).coreProvider()
        val cityApi = DaggerDataComponent.factory().create(coreProvider).cityApi()
        Log.d("GTA5", "${cityApi.getCities("New York")}")
    }
}