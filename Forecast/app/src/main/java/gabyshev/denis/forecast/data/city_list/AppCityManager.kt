package gabyshev.denis.forecast.data.city_list

import android.content.Context
import gabyshev.denis.forecast.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import java.io.InputStream
import java.io.InputStreamReader
import android.content.res.AssetManager
import android.util.JsonReader
import gabyshev.denis.forecast.data.city_list.model.City
import gabyshev.denis.forecast.di.ActivityContext
import gabyshev.denis.forecast.di.PerActivity
import gabyshev.denis.forecast.di.PerFragment


/**
 * Created by denis on 24/12/2017.
 */
class AppCityManager
    @Inject constructor(@ActivityContext val context: Context)
    : CityManager {


    private fun loadJSONFromAsset(context: Context): InputStream {
        val am: AssetManager = context.assets
        val inputStream: InputStream = am.open("city.list.json")

        return inputStream
    }

    private fun readJsonStream(input: InputStream, city: String): ArrayList<City> {
        val reader: JsonReader = JsonReader(InputStreamReader(input, "UTF-8"))
        try {
            return readMessageArray(reader, city)
        } finally {
            reader.close()
        }
    }

    private fun readMessageArray(reader: JsonReader, city: String): ArrayList<City> {
        val messages = ArrayList<City>()

        reader.beginArray()
        while(reader.hasNext()) {
            val value: City = readMessage(reader);

            if(value.name!!.equals(city, true)) {
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
            if (value == "id") {
                id = reader.nextLong()
            } else if (value == "name") {
                name = reader.nextString()
            } else if (value == "country"){
                country = reader.nextString()
            } else {
                reader.skipValue()
            }
        }
        reader.endObject()

        return City(id, name, country)
    }

    override fun getCityList(city: String): ArrayList<City> = readJsonStream(loadJSONFromAsset(context), city)

}