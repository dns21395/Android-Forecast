package gabyshev.denis.forecast.core.redux

interface  Middleware<State : Any> {

    fun bind(
        action: Action,
        state: State,
        dispatch: (Action) -> Unit
    )
}
