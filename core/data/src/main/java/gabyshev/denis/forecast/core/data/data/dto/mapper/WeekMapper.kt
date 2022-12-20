package gabyshev.denis.forecast.core.data.data.dto.mapper

import gabyshev.denis.forecast.core.data.api.entity.Day
import gabyshev.denis.forecast.core.data.data.dto.week.DailyData
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

internal fun DailyData.toDomain(): List<Day> {

    val array: ArrayList<Day> = arrayListOf()

    for (i in 0..6) {
        val dayName = days[i].toDay(i)
        val minTemperature = temperatureMax[i]
        val maxTemperature = temperatureMin[i]

        val day = Day(
            dayName = dayName,
            minTemperature = "$minTemperature °C",
            maxTemperature = "$maxTemperature °C"
        )

        array.add(day)
    }

    return array
}

private fun String.toDay(i: Int): String {
    if (i == 0) return "Today"
    if (i == 1) return "Tomorrow"
    val inputFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
    val outputFormat: DateFormat = SimpleDateFormat("EEEE")
    val date: Date = inputFormat.parse(this)
    return outputFormat.format(date)
}