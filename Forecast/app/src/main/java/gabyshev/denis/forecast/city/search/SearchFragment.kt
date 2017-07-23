package gabyshev.denis.forecast.city.search

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import gabyshev.denis.forecast.App
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.utils.RxBus
import gabyshev.denis.forecast.utils.RxRefreshPage
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_city_search.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * Created by Borya on 22.07.2017.
 */
class SearchFragment : Fragment() {
    private val TAG = "SearchFragment"

    lateinit var animator: ObjectAnimator

    @Inject lateinit var rxBus: RxBus
    private var subsriptions = CompositeDisposable()

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (context.applicationContext as App).component.inject(this)

        animator = ObjectAnimator.ofFloat(search, "rotation", 0f, 360f)

        setupViews()

        rxListener()
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

        search.setOnClickListener {
            hideKeyboard()
            getCityList()
        }
    }

    private fun turn360SearchButton() {
        animator.duration = 1500
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.RESTART
        animator.start()
    }

    private fun rxListener() {
        subsriptions.add(
                rxBus.toObservable()
                        .subscribe{
                            if(it is RxRefreshPage) {
                                stopTurn360SearchButton()
                            }
                        }
        )
    }

    fun stopTurn360SearchButton() {
        animator.end()
    }

    override fun onDestroy() {
        subsriptions.dispose()
        super.onDestroy()
    }

    private fun hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(content.windowToken, 0);
    }
}