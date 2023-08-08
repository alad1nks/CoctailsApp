package com.example.coctailsapp.data.entities

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.coctailsapp.ui.cocktails.model.CocktailItem

@Entity(tableName = "cocktails")
data class CocktailEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val ingredients: List<IngredientEntity>,
    val recipe: String,
    val image: Bitmap
) {
    fun toUi(): CocktailItem {
        return CocktailItem(id, title, image)
    }
}
