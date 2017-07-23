package gabyshev.denis.forecast.city

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.readystatesoftware.systembartint.SystemBarTintManager
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.city.viewpager.CityViewPagerAdapter
import kotlinx.android.synthetic.main.activity_city.*

/**
 * Created by Borya on 22.07.2017.
 */

class CityActivity : AppCompatActivity(), CityViewPagerController {
    override fun setPage(page: Int) {
        viewPager.currentItem = page
    }

    private lateinit var viewPagerAdapter: CityViewPagerAdapter


    private val TAG = "CityActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        transparentStatusBar()

        viewPager.offscreenPageLimit = 2
        viewPagerAdapter = CityViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

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

    override fun onBackPressed() {
        if(viewPager.currentItem == 1) {
            viewPager.currentItem = 0

        } else {
            super.onBackPressed()
        }
    }

}
