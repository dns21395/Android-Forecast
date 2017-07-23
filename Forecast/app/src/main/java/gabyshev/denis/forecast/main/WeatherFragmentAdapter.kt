package gabyshev.denis.forecast.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import gabyshev.denis.forecast.main.week.WeekFragment

/**
 * Created by Borya on 23.07.2017.
 */
class WeatherFragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        if(position == 0) {
            return CurrentFragment()
        } else {
            return WeekFragment()
        }
    }

    override fun getCount(): Int = 2
}