package gabyshev.denis.forecast.data.network.model.weekPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import gabyshev.denis.forecast.weather_api.weekPojo.Coord


class City {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("coord")
    @Expose
    var coord: Coord? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("population")
    @Expose
    var population: Int? = null

}
