package gabyshev.denis.forecast.ui.weather.week

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.data.weather.WeekWeather
import gabyshev.denis.forecast.ui.base.BaseFragment
import gabyshev.denis.forecast.weather_api.weekPojo.WeekPojo
import kotlinx.android.synthetic.main.fragment_main_week.*
import javax.inject.Inject

/**
 * Created by denis on 26/12/2017.
 */
class WeekFragment : BaseFragment(), WeekMvpView {

    companion object {
        fun newInstance(): WeekFragment {
            val args = Bundle()
            val fragment = WeekFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject lateinit var presenter: WeekMvpPresenter<WeekMvpView>

    @Inject lateinit var layoutManager: LinearLayoutManager

    @Inject lateinit var adapter: WeekAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_main_week, container, false)

        val component = getActivityComponent()
        component?.inject(this)

        presenter.onAttach(this)

        return view
    }

    override fun setUp(view: View?) {
        presenter.getWeekWeather()
    }

    override fun setRecyclerView(days: ArrayList<WeekWeather>) {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.updateItems(days)

    }
}