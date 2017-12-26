package gabyshev.denis.forecast.weather_api.currentPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Clouds {

    @SerializedName("all")
    @Expose
    var all: Int? = null

}
