package gabyshev.denis.forecast.main.week

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.weather_api.weekPojo.WeekPojo

/**
 * Created by Borya on 23.07.2017.
 */
class WeekAdapter(private val context: Context, private val weekPojo: WeekPojo) : RecyclerView.Adapter<WeekHolder>() {
    override fun onBindViewHolder(holder: WeekHolder?, position: Int) {
        holder?.bind(weekPojo.list!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeekHolder {
        return WeekHolder(LayoutInflater.from(context).inflate(R.layout.fragment_main_week_item, parent, false))

    }

    override fun getItemCount(): Int = weekPojo.list!!.size

}