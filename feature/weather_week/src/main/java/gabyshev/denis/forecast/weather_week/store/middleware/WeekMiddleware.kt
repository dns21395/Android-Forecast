package gabyshev.denis.forecast.weather_week.store.middleware

import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.WeatherApi
import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.core.redux.Middleware
import gabyshev.denis.forecast.weather_week.store.InitWeekScreen
import gabyshev.denis.forecast.weather_week.store.WeekState
import javax.inject.Inject

internal class WeekMiddleware @Inject constructor(
    private val weatherApi: WeatherApi,
    private val cityApi: CityApi
) : Middleware<WeekState> {

    override suspend fun bind(
        action: Action,
        state: WeekState,
        dispatch: (Action) -> Unit
    ) {
        when (action) {
            is InitWeekScreen -> {
                val cityLocation = cityApi.getSelectedCity().location
                val weather = weatherApi.getWeatherData(cityLocation.latitude, cityLocation.longitude)
            }
        }
    }
}