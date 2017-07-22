package gabyshev.denis.forecast.city

import android.content.Context
import android.content.res.AssetManager
import android.util.JsonReader
import android.util.Log
import gabyshev.denis.forecast.utils.City
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by Borya on 22.07.2017.
 */
class CityUtils {
    private val TAG = "CityUtils";

    companion object {
        private var instance: CityUtils? = null

        fun instance(): CityUtils? {
            if(instance == null) {
                instance = CityUtils()
            }
            return instance
        }
    }

    private fun loadJSONFromAsset(context: Context): InputStream {
        val am: AssetManager = context.assets
        val inputStream: InputStream = am.open("city.list.json")

        return inputStream
    }

    fun readJsonStream(input: InputStream): ArrayList<City> {
        val reader: JsonReader = JsonReader(InputStreamReader(input, "UTF-8"))
        try {
            return readMessageArray(reader)
        } finally {
            reader.close()
        }
    }

    fun readMessageArray(reader: JsonReader): ArrayList<City> {
        val messages = ArrayList<City>()

        reader.beginArray()
        while(reader.hasNext()) {
            val city: City = readMessage(reader);

            if(city.name!!.equals("TOKYO", true)) {
                messages.add(city)
            }
        }
        reader.endArray()

        return messages
    }

    fun readMessage(reader: JsonReader): City {
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

    fun getCityList(context: Context) {
        Log.d(TAG, "getCityList")
        readJsonStream(loadJSONFromAsset(context))
    }










}