package gabyshev.denis.forecast.main.week

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.App
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.utils.RxBus
import gabyshev.denis.forecast.utils.RxTomorrow
import gabyshev.denis.forecast.weather_api.RetrofitWeatherService
import gabyshev.denis.forecast.weather_api.weekPojo.WeekPojo
import kotlinx.android.synthetic.main.fragment_main_week.*
import javax.inject.Inject

/**
 * Created by Borya on 23.07.2017.
 */
class WeekFragment : Fragment() {

    private val TAG = "WeekFragment"

    @Inject lateinit var rxBus: RxBus
    @Inject lateinit var retrofitWeatherService: RetrofitWeatherService

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "WeekFragment onCreated")

        (context.applicationContext as App).component.inject(this)

        recyclerView.layoutManager = LinearLayoutManager(context)

        setAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main_week, container, false)
    }

    private fun setAdapter() {
        retrofitWeatherService.getWeekWeather(context, object : RetrofitWeatherService.WeatherCallback<WeekPojo> {
            override fun onSuccess(t: WeekPojo) {
                Log.d(TAG, "onSuccess : ${t.cnt}" )
                recyclerView.adapter = WeekAdapter(context, t)
                rxBus.send(RxTomorrow(
                        t.city?.name!!,
                        t.list!![0].weather!![0].icon!!,
                        t.list!![0].temp?.day!!.toInt(),
                        t.list!![0].weather!![0].description!!
                ))

            }

        })
    }


}