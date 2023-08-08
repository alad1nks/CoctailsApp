package com.example.coctailsapp.ui.addcocktail.model

import com.example.coctailsapp.data.entities.IngredientEntity
import com.example.coctailsapp.delegate.DelegateAdapterItem

data class IngredientItem(
    val id: Int,
    val name: String
) : DelegateAdapterItem {
    override fun id(): Any = id
    override fun content(): Any = name

    fun toEntity(): IngredientEntity {
        return IngredientEntity(id, name)
    }
}