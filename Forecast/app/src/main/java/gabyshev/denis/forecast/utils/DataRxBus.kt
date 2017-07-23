package gabyshev.denis.forecast.utils

/**
 * Created by Borya on 22.07.2017.
 */

data class RxGetCity(val arrayCities: ArrayList<City>)

class RxRefreshPage()

data class RxTomorrow(val city: String, val icon: String, val celsius: Int, val description: String)