package com.dani.marvelapi.utils.converters

import androidx.room.TypeConverter
import com.dani.domain.Url
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Room [TypeConverter] for [List]
 */
class UrlListConverter {
    /**
     * Converts a List into a String
     *
     * @param list the list to convert
     * @return the serialized list as a String
     */
    @TypeConverter
    fun urlItemToString(list: MutableList<Url>): String? {
        return Gson().toJson(list)
    }

    /**
     * Converts a serialized list (as a String) into a List
     *
     * @param stringList
     * @return the List
     */
    @TypeConverter
    fun stringToUrlItem(stringList: String?): MutableList<Url>? {
        return if (stringList == null) null
        else Gson().fromJson(stringList, object : TypeToken<MutableList<Url>>() {}.type)
    }
}
