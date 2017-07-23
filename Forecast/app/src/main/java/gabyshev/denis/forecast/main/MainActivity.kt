package gabyshev.denis.forecast.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatDrawableManager
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.city.CityActivity
import gabyshev.denis.forecast.settings.AppPreferences
import gabyshev.denis.forecast.utils.ViewBuildHelper
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    val arrayBackgrounds = arrayOf(R.drawable.background_1,
            R.drawable.background_2,
            R.drawable.background_3,
            R.drawable.background_4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(AppPreferences.instance()?.getCity(this) == 0) {
            startActivity(Intent(this, CityActivity::class.java))
            finish()
        }

        ViewBuildHelper.transparentStatusBar(this)

        background.setImageDrawable(AppCompatDrawableManager.get().getDrawable(this, arrayBackgrounds[Random().nextInt(arrayBackgrounds.size)]))

        viewPager.adapter = WeatherFragmentAdapter(supportFragmentManager)
        viewPager.offscreenPageLimit = 3
    }
}
