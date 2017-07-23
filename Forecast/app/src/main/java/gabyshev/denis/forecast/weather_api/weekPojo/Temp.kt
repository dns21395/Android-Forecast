package gabyshev.denis.forecast.weather_api.weekPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Temp {

    @SerializedName("day")
    @Expose
    var day: Double? = null
    @SerializedName("min")
    @Expose
    var min: Double? = null
    @SerializedName("max")
    @Expose
    var max: Double? = null
    @SerializedName("night")
    @Expose
    var night: Double? = null
    @SerializedName("eve")
    @Expose
    var eve: Double? = null
    @SerializedName("morn")
    @Expose
    var morn: Double? = null

}
