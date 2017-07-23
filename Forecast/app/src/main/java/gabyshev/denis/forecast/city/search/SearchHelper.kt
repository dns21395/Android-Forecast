package gabyshev.denis.forecast.city.search

import android.content.Context
import android.content.res.AssetManager
import android.util.JsonReader
import gabyshev.denis.forecast.App
import gabyshev.denis.forecast.utils.City
import gabyshev.denis.forecast.utils.RxBus
import gabyshev.denis.forecast.utils.RxGetCity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject

/**
 * Created by Borya on 22.07.2017.
 */
class SearchHelper {
    private val TAG = "SearchHelper";

    @Inject lateinit var rxBus: RxBus

    companion object {
        private var instance: SearchHelper? = null

        fun instance(): SearchHelper? {
            if(instance == null) {
                instance = SearchHelper()
            }
            return instance
        }
    }

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

    fun getCityList(context: Context, city: String) {
        (context.applicationContext as App).component.inject(this)

        var cities: ArrayList<City>? = null

        doAsync {
            cities = readJsonStream(loadJSONFromAsset(context), city)
            uiThread {
                rxBus.send(RxGetCity(cities!!))
            }

        }

    }










}