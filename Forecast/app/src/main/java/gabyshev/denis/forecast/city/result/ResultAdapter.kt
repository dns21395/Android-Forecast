package gabyshev.denis.forecast.city.result

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import gabyshev.denis.forecast.MainActivity
import gabyshev.denis.forecast.R
import gabyshev.denis.forecast.settings.AppPreferences
import gabyshev.denis.forecast.utils.City

/**
 * Created by Borya on 22.07.2017.
 */
class ResultAdapter(private val context: Context, private val arrayCities: ArrayList<City>) : RecyclerView.Adapter<ResultHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ResultHolder {
        return ResultHolder(LayoutInflater.from(context).inflate(R.layout.fragment_city_result_holder_2, parent, false))
    }

    override fun getItemCount(): Int = arrayCities.size


    override fun onBindViewHolder(holder: ResultHolder?, position: Int) {
        holder?.bind(arrayCities[position])

        holder?.itemView?.setOnClickListener {
            AppPreferences.instance()?.setCity(context, arrayCities[position].id.toInt())
            context.startActivity(Intent(context, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }
    }
}