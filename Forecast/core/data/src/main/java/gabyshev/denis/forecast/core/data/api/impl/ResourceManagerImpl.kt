package gabyshev.denis.forecast.core.data.api.impl

import android.content.Context
import gabyshev.denis.forecast.core.data.api.ResourceManagerApi
import javax.inject.Inject

class ResourceManagerImpl @Inject constructor(
    private val context: Context,
) : ResourceManagerApi {

    override fun getString(resourceId: Int): String = context.getString(resourceId)
}