package gabyshev.denis.forecast.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import gabyshev.denis.forecast.main.week.WeekFragment

/**
 * Created by Borya on 23.07.2017.
 */
class WeatherFragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    private val current = CurrentFragment()
    private val tomorrow = TomorrowFragment()
    private val week = WeekFragment()

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> current
            1 -> tomorrow
            else -> week
        }
    }

    override fun getCount(): Int = 3
}