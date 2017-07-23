package gabyshev.denis.forecast.main.week

import android.support.v7.widget.AppCompatDrawableManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import gabyshev.denis.forecast.utils.ViewBuildHelper
import gabyshev.denis.forecast.weather_api.weekPojo.ListDay
import kotlinx.android.synthetic.main.fragment_main_week_item.view.*

/**
 * Created by Borya on 23.07.2017.
 */
class WeekHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private val TAG = "WeekHolder"

    fun bind(day: ListDay, dayWeek: String) = with(itemView) {
        resultParent.background.alpha = 40
        weatherImage.setImageDrawable(AppCompatDrawableManager.get().getDrawable(context, ViewBuildHelper.getDrawable(day.weather!![0].icon)))
        celsius.text = "${day.temp?.max?.toInt()}\u00B0/${day.temp?.min?.toInt()}\u00B0"
        dayOfWeek.text = dayWeek
    }
}