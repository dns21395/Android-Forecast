package gabyshev.denis.forecast

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import gabyshev.denis.forecast.city.CityActivity
import gabyshev.denis.forecast.settings.AppPreferences
import gabyshev.denis.forecast.weather_api.RetrofitWeatherService
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    @Inject lateinit var retrofitWeatherService: RetrofitWeatherService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(AppPreferences.instance()?.getCity(this) == 0) {
            startActivity(Intent(this, CityActivity::class.java))
            finish()
        }

        (applicationContext as App).component.inject(this)

        retrofitWeatherService.getCurrentWeather(this)

        Log.d(TAG, "id = ${AppPreferences.instance()?.getCity(this)}")
    }


}
