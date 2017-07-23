package gabyshev.denis.forecast.weather_api.weekPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coord {

    @SerializedName("lon")
    @Expose
    var lon: Double? = null
    @SerializedName("lat")
    @Expose
    var lat: Double? = null

}
