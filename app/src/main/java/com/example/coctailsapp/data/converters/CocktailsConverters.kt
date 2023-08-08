package com.example.coctailsapp.data.converters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.coctailsapp.data.entities.IngredientEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.ByteArrayOutputStream

@ProvidedTypeConverter
class CocktailsConverters {
    @TypeConverter
    fun fromRecipes(recipes: List<IngredientEntity>): String {
        return Json.encodeToString(recipes)
    }

    @TypeConverter
    fun toRecipes(data: String): List<IngredientEntity> {
        return Json.decodeFromString(data)
    }

    @TypeConverter
    fun fromBitmap(bitmap: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }

    @TypeConverter
    fun toBitmap(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }
}