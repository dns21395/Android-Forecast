package gabyshev.denis.forecast.core.data.api

import gabyshev.denis.forecast.core.data.data.dto.WeatherDto
import gabyshev.denis.forecast.core.data.data.dto.week.WeekResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface WeatherApi {

    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double = 55.691048,
        @Query("longitude") long: Double = 37.727890
    ): WeatherDto

    @GET("/v1/forecast?latitude=52.52&longitude=13.41&daily=apparent_temperature_max,apparent_temperature_min&timezone=Europe/Moscow")
    suspend fun getWeekData(
        @Query("latitude") latitude: Double = 55.691048,
        @Query("longitude") longitude: Double = 37.727890
    ): WeekResponseDto
}