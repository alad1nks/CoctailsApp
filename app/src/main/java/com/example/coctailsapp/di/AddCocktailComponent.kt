package com.example.coctailsapp.di

import com.example.coctailsapp.ui.addcocktail.view.AddCocktailFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        AddCocktailModule::class
    ]
)
interface AddCocktailComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): AddCocktailComponent
    }
    fun inject(fragment: AddCocktailFragment)
}