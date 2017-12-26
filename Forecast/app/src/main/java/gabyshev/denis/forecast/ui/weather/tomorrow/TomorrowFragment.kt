package gabyshev.denis.forecast.ui.weather.tomorrow

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.data.weather.DayWeather
import gabyshev.denis.forecast.ui.base.BaseFragment
import gabyshev.denis.forecast.ui.weather.WeatherActivity
import gabyshev.denis.forecast.utils.CommonUtils
import kotlinx.android.synthetic.main.fragment_main_current.*
import javax.inject.Inject

/**
 * Created by denis on 26/12/2017.
 */
class TomorrowFragment : BaseFragment(), TomorrowMvpView {

    companion object {
        fun newInstance(): TomorrowFragment {
            val args = Bundle()
            val fragment = TomorrowFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject lateinit var presenter: TomorrowMvpPresenter<TomorrowMvpView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_main_current, container, false)

        val component = getActivityComponent()
        component?.inject(this)

        presenter.onAttach(this)

        return view
    }

    override fun setUp(view: View?) {
        presenter.getTomorrowWeather()

        cityName.setOnClickListener {
            (activity as WeatherActivity).openSelectCityActivity()
        }
    }

    override fun updateUI(tomorrowWeather: DayWeather?) {
        weatherImage.setImageDrawable(ContextCompat.getDrawable(context!!, tomorrowWeather?.drawable!!))
        cityName.text = tomorrowWeather.city
        dayHour.text = getString(R.string.tomorrow)
        temp.text = tomorrowWeather.temperature
        description.text = tomorrowWeather.description
    }
}