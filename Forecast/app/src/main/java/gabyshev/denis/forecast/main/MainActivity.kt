package gabyshev.denis.forecast.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.city.CityActivity
import gabyshev.denis.forecast.settings.AppPreferences
import gabyshev.denis.forecast.utils.ViewBuildHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(AppPreferences.instance()?.getCity(this) == 0) {
            startActivity(Intent(this, CityActivity::class.java))
            finish()
        }

        ViewBuildHelper.transparentStatusBar(this)

        viewPager.adapter = WeatherFragmentAdapter(supportFragmentManager)
        viewPager.offscreenPageLimit = 3
    }
}
