package gabyshev.denis.forecast.weather_week.store.middleware

import gabyshev.denis.forecast.core.data.api.interactor.WeekInteractor
import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.core.redux.Middleware
import gabyshev.denis.forecast.weather_week.store.InitWeekScreen
import gabyshev.denis.forecast.weather_week.store.OnReceivedDaysWeek
import gabyshev.denis.forecast.weather_week.store.WeekState
import javax.inject.Inject

internal class WeekMiddleware @Inject constructor(
    private val weekInteractor: WeekInteractor,
) : Middleware<WeekState> {

    override suspend fun bind(
        action: Action,
        state: WeekState,
        dispatch: (Action) -> Unit,
    ) {
        when (action) {
            is InitWeekScreen -> {
                val daysWeek = weekInteractor.getWeekWeather()
                dispatch(OnReceivedDaysWeek(daysWeek))
            }
        }
    }
}