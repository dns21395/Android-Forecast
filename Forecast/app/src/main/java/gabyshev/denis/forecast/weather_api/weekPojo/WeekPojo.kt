package gabyshev.denis.forecast.weather_api.weekPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeekPojo {

    @SerializedName("city")
    @Expose
    var city: City? = null
    @SerializedName("cod")
    @Expose
    var cod: String? = null
    @SerializedName("message")
    @Expose
    var message: Double? = null
    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null
    @SerializedName("list")
    @Expose
    var list: List<ListDay>? = null

}
