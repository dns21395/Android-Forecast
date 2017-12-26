package gabyshev.denis.forecast.utils

import gabyshev.denis.forecast.R

/**
 * Created by denis on 26/12/2017.
 */
class WeatherImageUtils {
    companion object {
        fun getDrawable(description: String?): Int {
            return when (description) {
                "01d" -> R.drawable.d_clear_sky
                "01n" -> R.drawable.n_clear_sky
                "02d" -> R.drawable.d_few_clouds
                "02n" -> R.drawable.n_few_clouds
                "03d", "03n", "04d", "04n" -> R.drawable.scattered_broken_clouds
                "09n" -> R.drawable.shower_rain
                "10d" -> R.drawable.d_rain
                "10n" -> R.drawable.n_rain
                "13d", "13n" -> R.drawable.snow
                else -> R.drawable.mist
            }
        }
    }
}