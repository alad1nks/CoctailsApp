package com.example.coctailsapp.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class IngredientEntity(
    val id: Int,
    val text: String
)
