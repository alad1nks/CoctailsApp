package com.example.coctailsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coctailsapp.data.converters.CocktailsConverters
import com.example.coctailsapp.data.entities.CocktailEntity

@Database(
    entities = [
        CocktailEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(CocktailsConverters::class)
abstract class CocktailsDatabase : RoomDatabase() {
    abstract fun cocktailsDao(): CocktailsDao
}