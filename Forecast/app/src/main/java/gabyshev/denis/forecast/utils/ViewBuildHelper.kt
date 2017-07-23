package gabyshev.denis.forecast.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import com.readystatesoftware.systembartint.SystemBarTintManager
import gabyshev.denis.forecast.R

/**
 * Created by Borya on 23.07.2017.
 */
object ViewBuildHelper {
    fun getDrawable(description : String?): Int {
        return when(description) {
            "01d" -> R.drawable.d_clear_sky
            "01n" -> R.drawable.n_clear_sky
            "02d" -> R.drawable.d_few_clouds
            "02n" -> R.drawable.n_few_clouds
            "03d", "03n", "04d", "04n" -> R.drawable.scattered_broken_clouds
            "09n" -> R.drawable.shower_rain
            "10d" -> R.drawable.d_rain
            "10n" -> R.drawable.n_rain
            "13d", "13n" -> R.drawable.snow
            else -> R.drawable.mist
        }
    }

    fun transparentStatusBar(activity: Activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            activity.window.statusBarColor = Color.TRANSPARENT
        }

        val tintManager = SystemBarTintManager(activity)
        // enable status bar tint
        tintManager.isStatusBarTintEnabled = true
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true)
    }
}