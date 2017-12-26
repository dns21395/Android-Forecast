package gabyshev.denis.forecast.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.ui.base.BaseActivity
import gabyshev.denis.forecast.ui.city.SelectCityActivity
import gabyshev.denis.forecast.ui.weather.WeatherActivity
import javax.inject.Inject

/**
 * Created by denis on 24/12/2017.
 */
class SplashActivity : BaseActivity(), SplashMvpView {
    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, SplashActivity::class.java)
    }

    @Inject lateinit var presenter: SplashMvpPresenter<SplashMvpView>

    private val TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        activityComponent.inject(this)

        setUp()

        presenter.onAttach(this)


    }

    override fun setUp() {
        transparentStatusBar()
    }

    override fun openSelectCityActivity() {
        startActivity(SelectCityActivity.getStartIntent(this))
        finish()
    }

    override fun openWeatherActivity() {

        startActivity(WeatherActivity.getStartIntent(this))
        finish()
    }
}