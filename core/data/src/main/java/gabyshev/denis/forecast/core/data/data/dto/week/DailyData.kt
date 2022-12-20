package gabyshev.denis.forecast.core.data.data.dto.week

import com.squareup.moshi.Json

internal data class DailyData(
    @field:Json(name = "time")
    val days: List<String>,
    @field:Json(name = "apparent_temperature_max")
    val temperatureMax: List<Double>,
    @field:Json(name = "apparent_temperature_min")
    val temperatureMin: List<Double>
)