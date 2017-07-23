package gabyshev.denis.forecast.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Borya on 23.07.2017.
 */
class WeatherFragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return CurrentFragment()
    }

    override fun getCount(): Int = 1
}