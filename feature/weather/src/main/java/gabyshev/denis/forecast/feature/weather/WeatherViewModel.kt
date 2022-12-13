package gabyshev.denis.forecast.feature.weather

import androidx.lifecycle.ViewModel
import gabyshev.denis.forecast.feature.weather.store.WeatherStore
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    private val store: WeatherStore
) : ViewModel() {

    init {
        store.wire()
    }
}