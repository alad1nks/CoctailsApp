package com.example.coctailsapp.di

import android.content.Context
import androidx.room.Room
import com.example.coctailsapp.data.converters.CocktailsConverters
import com.example.coctailsapp.data.db.CocktailsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    private val converters = CocktailsConverters()
    private lateinit var INSTANCE: CocktailsDatabase

    @Provides
    @Singleton
    fun provideFilmsDatabase(context: Context): CocktailsDatabase {
        synchronized(CocktailsDatabase::class.java) {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    CocktailsDatabase::class.java,
                    "cocktails_database")
                    .addTypeConverter(converters)
                    .build()
            }
        }
        return INSTANCE
    }
}