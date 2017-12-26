package gabyshev.denis.forecast.utils

import gabyshev.denis.forecast.R
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by denis on 26/12/2017.
 */
class CommonUtils {
    companion object {
        fun getDayHour(): String {
            val format = SimpleDateFormat("EEEE hh:mm a", Locale.US)

            val calendar = Calendar.getInstance()

            return format.format(calendar.time)

        }

        fun convertDayFromCalendar(day: Int): String {
            val format = SimpleDateFormat("EEEE", Locale.US)

            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, day + 1)

            return format.format(calendar.time)
        }

        fun getBackground(): Int {
            val arrayBackgrounds = arrayOf(R.drawable.background_1,
                    R.drawable.background_2,
                    R.drawable.background_3,
                    R.drawable.background_4,
                    R.drawable.splash,
                    R.drawable.city_background)

            return arrayBackgrounds[Random().nextInt(arrayBackgrounds.size)]
        }

    }
}