package gabyshev.denis.forecast.core.data.data.dto.week

import com.squareup.moshi.Json

internal data class WeekResponseDto(
    @field:Json(name = "daily")
    val daily: DailyData
)