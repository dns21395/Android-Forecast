package gabyshev.denis.forecast.ui.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import gabyshev.denis.forecast.di.component.ActivityComponent
import gabyshev.denis.forecast.utils.KeyboardUtils
import org.jetbrains.anko.support.v4.toast

/**
 * Created by denis on 24/12/2017.
 */
abstract class BaseFragment : Fragment(), MvpView {
    var activity: BaseActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is BaseActivity) {
            activity = context
        }
    }

    override fun onDetach() {
        activity = null
        super.onDetach()
    }

    override fun hideKeyboard() {
        KeyboardUtils.hideSoftInput(activity as Activity)
    }

    protected abstract fun setUp(view: View?)

    override fun showMessage(message: String) {
        toast(message)
    }

    fun getActivityComponent(): ActivityComponent? = activity?.activityComponent
}