package gabyshev.denis.forecast.ui.city.search

import android.animation.ObjectAnimator
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.ui.base.BaseFragment
import gabyshev.denis.forecast.ui.city.SelectCityActivity
import kotlinx.android.synthetic.main.fragment_city_search.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * Created by denis on 24/12/2017.
 */
class SearchCityFragment : BaseFragment(), SearchCityMvpView {
    companion object {
        fun newInstance(): SearchCityFragment {
            val args = Bundle()
            val fragment = SearchCityFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val TAG = "SearchCityFragment"

    @Inject lateinit var presenter: SearchCityMvpPresenter<SearchCityMvpView>

    private lateinit var animator: ObjectAnimator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_city_search, container, false)

        val component = getActivityComponent()
        component?.inject(this)


        presenter.onAttach(this)

        return view
    }

    override fun setUp(view: View?) {
        animator = ObjectAnimator.ofFloat(search, "rotation", 0f, 360f)

        cityName.setOnEditorActionListener { _, i, _ ->
            if(i == EditorInfo.IME_ACTION_SEARCH) {
                when(animator.isRunning) {
                    true -> toast(getString(R.string.search_city_already))
                    false -> searchUserCity()
                }
            }
            false
        }

        search.setOnClickListener {
            hideKeyboard()
            when(animator.isRunning) {
                true -> toast(getString(R.string.search_city_already))
                false -> searchUserCity()
            }
        }

    }

    override fun startSearchAnimation() {
        cityName.inputType = InputType.TYPE_NULL;
        animator.duration = 1500
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.RESTART
        animator.start()
    }

    override fun stopSearchAnimation() {
        cityName.inputType = InputType.TYPE_CLASS_TEXT;
        animator.end()
    }

    override fun searchUserCity() {
        when(cityName.text.toString().trim().isNotEmpty()) {
            true -> {
                startSearchAnimation()
                presenter.getCityList(cityName.text.toString().trim())
            }
            false -> toast(R.string.empty_field)
        }
    }

     override fun moveToNextPage() {
        (activity as SelectCityActivity).setViewPagerPage(1)
    }
}