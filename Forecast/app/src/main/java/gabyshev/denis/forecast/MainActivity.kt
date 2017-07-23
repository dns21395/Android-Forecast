package gabyshev.denis.forecast

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import gabyshev.denis.forecast.city.CityActivity
import gabyshev.denis.forecast.settings.AppPreferences

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(AppPreferences.instance()?.getCity(this) == null) {
            startActivity(Intent(this, CityActivity::class.java))
            finish()
        }
    }


}
