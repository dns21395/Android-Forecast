package gabyshev.denis.forecast.ui.city

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import gabyshev.denis.forecast.ui.city.result.ResultCityFragment
import gabyshev.denis.forecast.ui.city.search.SearchCityFragment

/**
 * Created by denis on 24/12/2017.
 */
class SelectCityAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    private val fragments = arrayOf(SearchCityFragment.newInstance(), ResultCityFragment.newInstance())

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size
}