package gabyshev.denis.forecast.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatDrawableManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.App
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.city.CityActivity
import gabyshev.denis.forecast.utils.RxBus
import gabyshev.denis.forecast.utils.RxTomorrow
import gabyshev.denis.forecast.utils.ViewBuildHelper
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_main_current.*
import javax.inject.Inject

/**
 * Created by Borya on 23.07.2017.
 */
class TomorrowFragment : Fragment() {

    private val TAG = "TomorrowFragment"

    @Inject lateinit var rxBus: RxBus
    private var subscriptions = CompositeDisposable()

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "Tomorrow Fragment On Created")

        (context.applicationContext as App).component.inject(this)

        cityName.setOnClickListener {
            startActivity(Intent(activity, CityActivity::class.java))
        }

        rxListener()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_main_current, container, false)
    }

    private fun rxListener() {
        subscriptions.add(
                rxBus.toObservable().subscribe{
                    if(it is RxTomorrow) {
                        cityName.text = it.city
                        weatherImage.setImageDrawable(AppCompatDrawableManager.get().getDrawable(context, ViewBuildHelper.getDrawable(it.icon)))
                        dayHour.text = getString(R.string.tomorrow)
                        temp.text = "${it.celsius}\u2103"
                        description.text = it.description.toUpperCase()
                    }
                }
        )
    }

    override fun onDestroy() {
        subscriptions.dispose()
        super.onDestroy()
    }


}