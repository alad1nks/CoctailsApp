package com.example.coctailsapp.di

import com.example.coctailsapp.ui.addcocktail.view.AddIngredientDialogFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        AddIngredientModule::class
    ]
)
interface AddIngredientComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): AddIngredientComponent
    }
    fun inject(fragment: AddIngredientDialogFragment)
}