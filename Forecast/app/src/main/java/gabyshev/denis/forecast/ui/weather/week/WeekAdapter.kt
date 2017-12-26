package gabyshev.denis.forecast.ui.weather.week

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.data.weather.WeekWeather
import kotlinx.android.synthetic.main.fragment_main_week_item.view.*

/**
 * Created by denis on 26/12/2017.
 */
class WeekAdapter(val context: Context) : RecyclerView.Adapter<WeekAdapter.WeekViewHolder>() {
    private var days = ArrayList<WeekWeather>()

    override fun onBindViewHolder(holder: WeekViewHolder?, position: Int) {
        holder?.onBind(position)
    }

    override fun getItemCount(): Int = days.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeekViewHolder =
         WeekViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.fragment_main_week_item, parent, false))

    fun updateItems(array: ArrayList<WeekWeather>) {
        days = array
        notifyDataSetChanged()
    }

    inner class WeekViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(position: Int) = with(itemView) {
            val day = days[position]

            resultParent.background.alpha = 40

            dayOfWeek.text = day.day
            celsius.text = day.temperature
            weatherImage.setImageDrawable(ContextCompat.getDrawable(context, day.drawable!!))
        }
    }
}