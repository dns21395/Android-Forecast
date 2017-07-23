package gabyshev.denis.forecast.main.week

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.App
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.weather_api.RetrofitWeatherService
import gabyshev.denis.forecast.weather_api.weekPojo.WeekPojo
import javax.inject.Inject

/**
 * Created by Borya on 23.07.2017.
 */
class WeekFragment : Fragment() {

    private val TAG = "WeekFragment"

    @Inject lateinit var retrofitWeatherService: RetrofitWeatherService

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (context.applicationContext as App).component.inject(this)

        setAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main_week, container, false)
    }

    private fun setAdapter() {
        retrofitWeatherService.getWeekWeather(context, object : RetrofitWeatherService.WeatherCallback<WeekPojo> {
            override fun onSuccess(t: WeekPojo) {
                Log.d(TAG, "onSuccess : ${t.message}" )
            }

        })
    }


}