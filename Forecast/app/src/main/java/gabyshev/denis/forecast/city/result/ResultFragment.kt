package gabyshev.denis.forecast.city.result

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.App
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.city.CityViewPagerController
import gabyshev.denis.forecast.utils.RxBus
import gabyshev.denis.forecast.utils.RxGetCity
import gabyshev.denis.forecast.utils.RxRefreshPage
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_city_result.*
import javax.inject.Inject

/**
 * Created by Borya on 22.07.2017.
 */
class ResultFragment : Fragment() {
    private val TAG = "ResultFragment"

    @Inject lateinit var rxBus: RxBus
    private var subsriptions = CompositeDisposable()
    private lateinit var viewPagerListener: CityViewPagerController
    private lateinit var layoutManager: LinearLayoutManager

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (context.applicationContext as App).component.inject(this)

        viewPagerListener = activity as CityViewPagerController

        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        recyclerView.viewTreeObserver

        rxListener()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_city_result, container, false)
    }

    private fun rxListener() {
        subsriptions.add(
                rxBus.toObservable()
                        .subscribe{
                            if(it is RxGetCity) {
                                recyclerView.adapter = ResultAdapter(context, it.arrayCities)
                                viewPagerListener.setPage(1)
                                rxBus.send(RxRefreshPage())
                            }
                        }
        )
    }

    override fun onDestroy() {
        subsriptions.dispose()
        super.onDestroy()
    }
}