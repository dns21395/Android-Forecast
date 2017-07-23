package gabyshev.denis.forecast.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatDrawableManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.App
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.utils.ViewBuildHelper
import gabyshev.denis.forecast.weather_api.RetrofitWeatherService
import gabyshev.denis.forecast.weather_api.currentWeatherPojo.CurrentWeatherPojo
import kotlinx.android.synthetic.main.fragment_main_current.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by Borya on 23.07.2017.
 */
class CurrentFragment : Fragment() {

    private val TAG = "CurrentFragment"

    @Inject lateinit var retrofitWeatherService: RetrofitWeatherService

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (context.applicationContext as App).component.inject(this)

        setValues()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_main_current, container, false)
    }

    private fun setValues() {
        retrofitWeatherService.getCurrentWeather(context, object : RetrofitWeatherService.CurrentWeatherCallback {
            override fun onSuccess(t: CurrentWeatherPojo) {
                Log.d(TAG, "${t.weather!![0].icon} ${ViewBuildHelper.getDrawable(t.weather!![0].icon)}")


                weatherImage.setImageDrawable(AppCompatDrawableManager.get().getDrawable(context, ViewBuildHelper.getDrawable(t.weather!![0].icon)))
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