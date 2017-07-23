package gabyshev.denis.forecast.city.result

import android.support.v7.widget.RecyclerView
import android.view.View
import gabyshev.denis.forecast.utils.City
import kotlinx.android.synthetic.main.fragment_city_result_holder_2.view.*

/**
 * Created by Borya on 22.07.2017.
 */
class ResultHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun bind(city: City) = with(itemView) {
        cityCountryName.text = "${city.name}, ${city.country}"
        resultParent.background.alpha = 40
    }



}