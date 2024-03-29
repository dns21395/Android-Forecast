package gabyshev.denis.forecast.core.data.domain.interactor

import android.content.Context
import android.content.res.AssetManager
import android.util.JsonReader
import android.util.Log
import gabyshev.denis.forecast.core.data.api.entity.City
import gabyshev.denis.forecast.core.data.api.entity.Location
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject

class CitiesGetter @Inject constructor(
    private val context: Context,
) {

    fun getCities(city: String): List<City> =
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
        var location: Location? = null

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
                "coord" -> {
                    reader.beginObject()
                    reader.nextName()
                    val longitude = reader.nextDouble()
                    reader.nextName()
                    val latitude = reader.nextDouble()
                    location = Location(latitude, longitude)
                    reader.endObject()
                }
                else -> {
                    reader.skipValue()
                }
            }
        }
        reader.endObject()

        return City(
            id,
            name ?: "",
            country ?: "",
            location ?: Location(0.0, 0.0)
        )
    }
}