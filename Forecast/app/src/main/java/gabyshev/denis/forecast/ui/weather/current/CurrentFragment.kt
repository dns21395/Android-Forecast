package gabyshev.denis.forecast.ui.weather.current

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.data.weather.DayWeather
import gabyshev.denis.forecast.ui.base.BaseFragment
import gabyshev.denis.forecast.ui.weather.WeatherActivity
import gabyshev.denis.forecast.utils.CommonUtils
import gabyshev.denis.forecast.utils.WeatherImageUtils
import gabyshev.denis.forecast.weather_api.currentPojo.CurrentPojo
import kotlinx.android.synthetic.main.fragment_main_current.*
import javax.inject.Inject

/**
 * Created by denis on 26/12/2017.
 */
class CurrentFragment : BaseFragment(), CurrentMvpView {
    companion object {
        fun newInstance(): CurrentFragment {
            val args = Bundle()
            val fragment = CurrentFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val TAG = "CurrentFragment"

    @Inject lateinit var presenter: CurrentMvpPresenter<CurrentMvpView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_main_current, container, false)

        val component = getActivityComponent()
        component?.inject(this)

        presenter.onAttach(this)

        return view
    }

    override fun setUp(view: View?) {
        presenter.getTodayWeather()

        cityName.setOnClickListener {
            (activity as WeatherActivity).openSelectCityActivity()
        }
    }

    override fun updateUI(currentWeather: DayWeather?) {
        weatherImage.setImageDrawable(ContextCompat.getDrawable(context!!, currentWeather?.drawable!!))
        cityName.text = currentWeather.city
        dayHour.text = CommonUtils.getDayHour()
        temp.text = currentWeather.temperature
        description.text = currentWeather.description
    }
}