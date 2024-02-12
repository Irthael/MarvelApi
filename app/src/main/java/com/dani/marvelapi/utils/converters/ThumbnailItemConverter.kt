package com.dani.marvelapi.utils.converters

import androidx.room.TypeConverter
import com.dani.domain.Image
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Room [TypeConverter] for [List]
 */
class ThumbnailItemConverter {
    /**
     * Converts a List into a String
     *
     * @param list the list to convert
     * @return the serialized list as a String
     */
    @TypeConverter
    fun thumbnailItemToString(item: Image): String? {
        return Gson().toJson(item)
    }

    /**
     * Converts a serialized list (as a String) into a List
     *
     * @param stringList
     * @return the List
     */
    @TypeConverter
    fun stringToThumbnailItem(stringList: String?): Image? {
        return if (stringList == null) null
        else Gson().fromJson(stringList, object : TypeToken<Image>() {}.type)
    }
}
