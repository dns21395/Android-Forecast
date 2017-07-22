package gabyshev.denis.forecast.city

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Borya on 22.07.2017.
 */
class CityViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        if(position == 0) {
            return SearchFragment()
        } else {
            return ResultFragment()
        }
    }

    override fun getCount(): Int = 2
}