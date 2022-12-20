package gabyshev.denis.forecast.core.data.data.dto.mapper

import gabyshev.denis.forecast.core.data.api.entity.Day
import gabyshev.denis.forecast.core.data.data.dto.week.DailyData

internal fun DailyData.toDomain(): List<Day> {

    val array: ArrayList<Day> = arrayListOf()

    for (i in 0..6) {
        val dayName = days[i]
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