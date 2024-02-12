package com.dani.marvelapi.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dani.marvelapi.model.database.entities.CharactersEntity
import com.dani.marvelapi.utils.converters.ThumbnailItemConverter
import com.dani.marvelapi.utils.converters.UrlListConverter

@Database(entities = [ CharactersEntity::class], version = 1, exportSchema = false)
@TypeConverters(UrlListConverter::class, ThumbnailItemConverter::class)
abstract class ApiCharactersDatabase : RoomDatabase() {
    abstract fun apiCharactersDao(): ApiCharactersDAO
}
