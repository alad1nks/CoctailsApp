package com.example.coctailsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coctailsapp.data.entities.CocktailEntity

@Dao
interface CocktailsDao {
    @Query("SELECT * FROM cocktails")
    fun getCocktails(): List<CocktailEntity>

    @Query("SELECT * FROM cocktails WHERE id = :id")
    fun getCocktails(id: Int): CocktailEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCocktail(cocktail: CocktailEntity)
}