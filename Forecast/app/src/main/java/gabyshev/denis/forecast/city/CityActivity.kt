package gabyshev.denis.forecast.city

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import gabyshev.denis.forecast.R

/**
 * Created by Borya on 22.07.2017.
 */

class CityActivity : AppCompatActivity() {
    private val TAG = "CityActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        Log.d(TAG, "onCreate")
        getCityList()

    }

    private fun getCityList() {
        CityUtils.instance()?.getCityList(this);
    }
}
