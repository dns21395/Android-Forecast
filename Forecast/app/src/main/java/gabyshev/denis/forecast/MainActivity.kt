package gabyshev.denis.forecast

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatDrawableManager
import android.util.Log
import gabyshev.denis.forecast.city.CityActivity
import gabyshev.denis.forecast.settings.AppPreferences
import gabyshev.denis.forecast.utils.ViewBuildHelper
import gabyshev.denis.forecast.weather_api.RetrofitWeatherService
import gabyshev.denis.forecast.weather_api.currentWeatherPojo.CurrentWeatherPojo
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
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

        ViewBuildHelper.transparentStatusBar(this)

        (applicationContext as App).component.inject(this)

        setValues()
    }

    private fun setValues() {
        retrofitWeatherService.getCurrentWeather(this, object : RetrofitWeatherService.CurrentWeatherCallback {
            override fun onSuccess(t: CurrentWeatherPojo) {
                Log.d(TAG, "${t.weather!![0].icon} ${ViewBuildHelper.getDrawable(t.weather!![0].icon)}")


                weatherImage.setImageDrawable(AppCompatDrawableManager.get().getDrawable(applicationContext, ViewBuildHelper.getDrawable(t.weather!![0].icon)))
                cityName.text = t.name
                dayHour.text = getDayHour()
                temp.text = "${(t.main?.temp?.toInt())}\u2103"
                description.text = t.weather!![0].description?.toUpperCase()


            }

        })
    }

    private fun getDayHour(): String {
        val format = SimpleDateFormat("EEEE hh:mm a", Locale.US)

        val calendar = Calendar.getInstance()

        return format.format(calendar.time)

    }



}
