package gabyshev.denis.forecast.city

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import gabyshev.denis.forecast.R
import kotlinx.android.synthetic.main.fragment_city_search.*

/**
 * Created by Borya on 22.07.2017.
 */
class SearchFragment : Fragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_city_search, container, false)
    }

    private fun getCityList() {
        CityUtils.instance()?.getCityList(context);
    }

    private fun setupViews() {
        cityName.setOnEditorActionListener { textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_SEARCH) {
                turn360SearchButton()
            }
            return@setOnEditorActionListener false
        }

        search.setOnClickListener { turn360SearchButton() }
    }

    private fun turn360SearchButton() {
        val animator: ObjectAnimator = ObjectAnimator.ofFloat(search, "rotation", 0f, 360f)
        animator.duration = 1500
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.RESTART
        animator.start()
    }
}