package com.dani.apimarvel.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dani.apimarvel.model.database.entities.CharactersEntity
import com.dani.apimarvel.utils.converters.ThumbnailItemConverter
import com.dani.apimarvel.utils.converters.UrlListConverter

@Database(entities = [ CharactersEntity::class], version = 1, exportSchema = false)
@TypeConverters(UrlListConverter::class, ThumbnailItemConverter::class)
abstract class ApiCharactersDatabase : RoomDatabase() {
    abstract fun apiCharactersDao(): ApiCharactersDAO
}
