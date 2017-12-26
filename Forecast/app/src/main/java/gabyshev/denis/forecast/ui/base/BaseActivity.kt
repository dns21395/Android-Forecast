package gabyshev.denis.forecast.ui.base

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.readystatesoftware.systembartint.SystemBarTintManager
import gabyshev.denis.forecast.di.component.ActivityComponent
import gabyshev.denis.forecast.di.component.ApplicationComponent
import gabyshev.denis.forecast.di.component.DaggerActivityComponent
import gabyshev.denis.forecast.di.module.ActivityModule
import gabyshev.denis.forecast.utils.KeyboardUtils
import gabyshev.denis.forecast.utils.app
import org.jetbrains.anko.toast

/**
 * Created by denis on 24/12/2017.
 */
abstract class BaseActivity: AppCompatActivity(), MvpView {
    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent(app.applicationComponent)
                .build()
    }

    protected abstract fun setUp()

    fun transparentStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = Color.TRANSPARENT

        val tintManager = SystemBarTintManager(this)
        // enable status bar tint
        tintManager.isStatusBarTintEnabled = true
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true)
    }


    override fun showMessage(message: String) {
        toast(message)
    }

    override fun hideKeyboard() {
        KeyboardUtils.hideSoftInput(this)
    }
}