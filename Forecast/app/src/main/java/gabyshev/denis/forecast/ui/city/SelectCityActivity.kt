package gabyshev.denis.forecast.ui.city

import android.content.Context
import android.content.Intent
import android.os.Bundle
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.ui.base.BaseActivity
import gabyshev.denis.forecast.ui.splash.SplashActivity
import gabyshev.denis.forecast.ui.weather.WeatherActivity
import kotlinx.android.synthetic.main.activity_select_city.*
import javax.inject.Inject

/**
 * Created by denis on 24/12/2017.
 */
class SelectCityActivity : BaseActivity(), SelectCityMvpView {
    @Inject lateinit var presenter: SelectCityMvpPresenter<SelectCityMvpView>

    @Inject lateinit var selectCityAdapter: SelectCityAdapter

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, SelectCityActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_city)

        activityComponent.inject(this)

        presenter.onAttach(this)

        setUp()
    }

    override fun setUp() {
        transparentStatusBar()
        setupViewPager()
    }

    private fun setupViewPager() {
        viewPager.offscreenPageLimit = selectCityAdapter.count
        viewPager.adapter = selectCityAdapter
    }

    override fun setViewPagerPage(page: Int) {
        viewPager.currentItem = page
    }

    override fun openSplashActivity() {
        startActivity(SplashActivity.getStartIntent(this).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
        finish()
    }

    override fun onBackPressed() {
        when(viewPager.currentItem) {
            1 -> viewPager.currentItem = 0
            else -> super.onBackPressed()
        }

    }
}