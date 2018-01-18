package gabyshev.denis.forecast.weather_api.weekPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListDay {

    @SerializedName("dt")
    @Expose
    val dt: Int? = null
    @SerializedName("temp")
    @Expose
    val temp: Temp? = null
    @SerializedName("pressure")
    @Expose
    val pressure: Double? = null
    @SerializedName("humidity")
    @Expose
    val humidity: Int? = null
    @SerializedName("weather")
    @Expose
    val weather: List<Weather>? = null
    @SerializedName("speed")
    @Expose
    val speed: Double? = null
    @SerializedName("deg")
    @Expose
    val deg: Int? = null
    @SerializedName("clouds")
    @Expose
    val clouds: Int? = null
    @SerializedName("rain")
    @Expose
    val rain: Double? = null

}
