package gabyshev.denis.forecast.ui.city.result

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.ui.base.BaseFragment
import gabyshev.denis.forecast.ui.city.SelectCityActivity
import kotlinx.android.synthetic.main.fragment_city_result.*
import javax.inject.Inject

/**
 * Created by denis on 25/12/2017.
 */
class ResultCityFragment : BaseFragment(), ResultCityMvpView, ResultCityAdapter.Callback {

    companion object {
        fun newInstance(): ResultCityFragment {
            val args = Bundle()
            val fragment = ResultCityFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val TAG = "ResultCityFragment"

    @Inject lateinit var presenter: ResultCityMvpPresenter<ResultCityMvpView>

    @Inject lateinit var adapter: ResultCityAdapter

    @Inject lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_city_result, container, false)

        val component = getActivityComponent()
        component?.inject(this)

        presenter.onAttach(this)

        return view
    }

    override fun setUp(view: View?) {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.callback = this
    }

    override fun openSplashActivity() {
        (activity as SelectCityActivity).openSplashActivity()
    }

    override fun onCitySelected(city: Long) {
       presenter.updateUserCity(city)
    }


}