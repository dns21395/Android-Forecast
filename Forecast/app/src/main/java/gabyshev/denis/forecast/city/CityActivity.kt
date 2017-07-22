package gabyshev.denis.forecast.city

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.readystatesoftware.systembartint.SystemBarTintManager
import gabyshev.denis.forecast.R

/**
 * Created by Borya on 22.07.2017.
 */

class CityActivity : AppCompatActivity() {
    private val TAG = "CityActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        transparentStatusBar()

    }

    private fun getCityList() {
        CityUtils.instance()?.getCityList(this);
    }

    private fun transparentStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT
        }

        val tintManager = SystemBarTintManager(this)
        // enable status bar tint
        tintManager.isStatusBarTintEnabled = true
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true)
    }
}
