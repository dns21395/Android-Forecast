package gabyshev.denis.forecast.core.redux

interface  Middleware<State : Any> {

    suspend fun bind(
        action: Action,
        state: State,
        dispatch: (Action) -> Unit
    )
}
