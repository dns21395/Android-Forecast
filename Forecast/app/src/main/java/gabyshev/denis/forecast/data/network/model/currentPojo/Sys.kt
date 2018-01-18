package gabyshev.denis.forecast.weather_api.currentPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sys {

    @SerializedName("message")
    @Expose
    val message: Double? = null
    @SerializedName("country")
    @Expose
    val country: String? = null
    @SerializedName("sunrise")
    @Expose
    val sunrise: Int? = null
    @SerializedName("sunset")
    @Expose
    val sunset: Int? = null

}
