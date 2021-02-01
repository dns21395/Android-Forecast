package gabyshev.denis.forecast.ui.weather

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.ui.base.BaseActivity
import gabyshev.denis.forecast.ui.city.SelectCityActivity
import gabyshev.denis.forecast.utils.CommonUtils
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by denis on 25/12/2017.
 */
class WeatherActivity : BaseActivity(), WeatherMvpView {


    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, WeatherActivity::class.java)
    }

    @Inject lateinit var presenter: WeatherMvpPresenter<WeatherMvpView>

    @Inject lateinit var adapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.inject(this)
        presenter.onAttach(this)

        setUp()
    }

    override fun setUp() {
        transparentStatusBar()
        setupViewPager()

        background.setImageDrawable(ContextCompat.getDrawable(this, CommonUtils.getBackground()))
    }

    private fun setupViewPager() {
        viewPager.offscreenPageLimit = 3
        viewPager.adapter = adapter
    }

    override fun openSelectCityActivity() {
        startActivity(SelectCityActivity.getStartIntent(this))
    }


}