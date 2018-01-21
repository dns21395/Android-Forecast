package gabyshev.denis.forecast.weather_api.weekPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Temp {

    @SerializedName("day")
    @Expose
    val day: Double? = null
    @SerializedName("min")
    @Expose
    val min: Double? = null
    @SerializedName("max")
    @Expose
    val max: Double? = null
    @SerializedName("night")
    @Expose
    val night: Double? = null
    @SerializedName("eve")
    @Expose
    val eve: Double? = null
    @SerializedName("morn")
    @Expose
    val morn: Double? = null

}
