package gabyshev.denis.forecast.ui.weather

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import gabyshev.denis.forecast.ui.weather.current.CurrentFragment
import gabyshev.denis.forecast.ui.weather.tomorrow.TomorrowFragment
import gabyshev.denis.forecast.ui.weather.week.WeekFragment

/**
 * Created by denis on 26/12/2017.
 */
class WeatherAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    private val fragments = arrayOf(CurrentFragment.newInstance(),
                                    TomorrowFragment.newInstance(),
                                    WeekFragment.newInstance())

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size
}