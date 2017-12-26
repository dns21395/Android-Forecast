package gabyshev.denis.forecast.weather_api.weekPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListDay {

    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("temp")
    @Expose
    var temp: Temp? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Double? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null
    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null
    @SerializedName("speed")
    @Expose
    var speed: Double? = null
    @SerializedName("deg")
    @Expose
    var deg: Int? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Int? = null
    @SerializedName("rain")
    @Expose
    var rain: Double? = null

}
