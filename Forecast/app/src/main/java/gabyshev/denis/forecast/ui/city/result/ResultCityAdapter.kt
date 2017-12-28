package gabyshev.denis.forecast.ui.city.result

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.data.city_list.model.City
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.di.PerFragment

import kotlinx.android.synthetic.main.fragment_city_result_holder.view.*
import javax.inject.Inject


/**
 * Created by denis on 25/12/2017.
 */
@PerFragment
class ResultCityAdapter
    @Inject constructor(@ActivityContext private val context: Context)
    : RecyclerView.Adapter<ResultCityAdapter.ResultCityViewHolder>() {
    private val TAG = "ResultCityAdapter"

    private var cities = ArrayList<City>()

    lateinit var callback: Callback

    override fun getItemCount(): Int = cities.size

    override fun onBindViewHolder(holder: ResultCityViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ResultCityViewHolder =
            ResultCityViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_city_result_holder, parent, false))

    fun updateCities(cities: ArrayList<City>) {
        Log.d(TAG, "updateCities : $cities")
        this.cities = cities
        notifyDataSetChanged()
    }

    interface Callback {
        fun onCitySelected(city: Long)
    }

    inner class ResultCityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) = with(itemView) {
            val city = cities[position]

            cityCountryName.text = "${city.name}, ${city.country}"
            resultParent.background.alpha = 40

            itemView.setOnClickListener {
                callback.onCitySelected(city.id)
            }
        }




    }
}