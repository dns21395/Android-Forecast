package gabyshev.denis.forecast.city.search

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import gabyshev.denis.forecast.R
import kotlinx.android.synthetic.main.fragment_city_search.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by Borya on 22.07.2017.
 */
class SearchFragment : Fragment() {
    private val TAG = "SearchFragment"

    lateinit var animator: ObjectAnimator

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animator = ObjectAnimator.ofFloat(search, "rotation", 0f, 360f)

        setupViews()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_city_search, container, false)
    }

    private fun getCityList() {
        if(cityName.text.toString().trim().isNotEmpty()) {
            turn360SearchButton()
            SearchHelper.instance()?.getCityList(context, cityName.text.toString().trim());
        } else {
            toast(R.string.empty_field)
        }
    }

    private fun setupViews() {
        cityName.setOnEditorActionListener { textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_SEARCH) {
                getCityList()
            }
            return@setOnEditorActionListener false
        }

        search.setOnClickListener { getCityList() }
    }

    private fun turn360SearchButton() {
        animator.duration = 1500
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.RESTART
        animator.start()
    }

    fun stopTurn360SearchButton() {
        animator.cancel()
    }
}