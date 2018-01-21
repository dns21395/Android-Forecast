package gabyshev.denis.forecast.weather_api.weekPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import gabyshev.denis.forecast.data.network.model.weekPojo.City

class WeekPojo {

    @SerializedName("city")
    @Expose
    val city: City? = null
    @SerializedName("cod")
    @Expose
    val cod: String? = null
    @SerializedName("message")
    @Expose
    val message: Double? = null
    @SerializedName("cnt")
    @Expose
    val cnt: Int? = null
    @SerializedName("list")
    @Expose
    val list: List<ListDay>? = null

}
