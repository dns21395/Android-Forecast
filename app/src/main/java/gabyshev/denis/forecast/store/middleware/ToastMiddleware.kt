package gabyshev.denis.forecast.store.middleware

import android.content.Context
import android.widget.Toast
import gabyshev.denis.forecast.core.common.store.ShowToastAction
import gabyshev.denis.forecast.core.redux.Action
import gabyshev.denis.forecast.core.redux.Middleware
import gabyshev.denis.forecast.core.store.AppState
import javax.inject.Inject

class ToastMiddleware @Inject constructor(
    private val context: Context,
) : Middleware<AppState> {

    override fun bind(action: Action, state: AppState, dispatch: (Action) -> Unit) {
        when (action) {
            is ShowToastAction -> Toast.makeText(context, action.text, Toast.LENGTH_LONG).show()
        }
    }
}