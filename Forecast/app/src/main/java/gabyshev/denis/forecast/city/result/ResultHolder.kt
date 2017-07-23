package gabyshev.denis.forecast.city.result

import android.content.ClipData
import android.graphics.Bitmap
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import com.squareup.picasso.Picasso
import gabyshev.denis.forecast.utils.BlurBuilder
import gabyshev.denis.forecast.utils.City
import jp.wasabeef.blurry.Blurry
import kotlinx.android.synthetic.main.fragment_city_result_holder_2.view.*
import java.util.*

/**
 * Created by Borya on 22.07.2017.
 */
class ResultHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun bind(city: City) = with(itemView) {
        cityCountryName.text = "${city.name}, ${city.country}"
        resultParent.background.alpha = 40
    }



}