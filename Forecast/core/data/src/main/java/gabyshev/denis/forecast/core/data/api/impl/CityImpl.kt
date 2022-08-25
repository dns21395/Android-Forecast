package gabyshev.denis.forecast.core.data.api.impl

import android.content.Context
import android.content.res.AssetManager
import android.util.JsonReader
import gabyshev.denis.forecast.core.data.api.CityApi
import gabyshev.denis.forecast.core.data.api.entity.City
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject

internal class CityImpl @Inject constructor(
    private val context: Context,
) : CityApi {

    override fun getCities(city: String): List<City> =
        readJsonStream(loadJSONFromAsset(context), city)

    private fun loadJSONFromAsset(context: Context): InputStream {
        val am: AssetManager = context.assets
        val inputStream: InputStream = am.open("city.list.json")

        return inputStream
    }

    private fun readJsonStream(input: InputStream, city: String): ArrayList<City> {
        val reader = JsonReader(InputStreamReader(input, "UTF-8"))
        try {
            return readMessageArray(reader, city)
        } finally {
            reader.close()
        }
    }

    private fun readMessageArray(reader: JsonReader, city: String): ArrayList<City> {
        val messages = ArrayList<City>()

        reader.beginArray()
        while (reader.hasNext()) {
            val value: City = readMessage(reader);

            if (value.name.equals(city, true)) {
                messages.add(value)
            }
        }
        reader.endArray()

        return messages
    }

    private fun readMessage(reader: JsonReader): City {
        var id: Long = -1
        var name: String? = null
        var country: String? = null

        reader.beginObject()

        while (reader.hasNext()) {
            val value: String = reader.nextName()
            when (value) {
                "id" -> {
                    id = reader.nextLong()
                }
                "name" -> {
                    name = reader.nextString()
                }
                "country" -> {
                    country = reader.nextString()
                }
                else -> {
                    reader.skipValue()
                }
            }
        }
        reader.endObject()

        return City(id, name ?: "", country ?: "")
    }
}