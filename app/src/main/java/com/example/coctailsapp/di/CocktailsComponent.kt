package com.example.coctailsapp.di

import com.example.coctailsapp.ui.cocktails.view.CocktailsFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        CocktailsModule::class
    ]
)
interface CocktailsComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): CocktailsComponent
    }
    fun inject(fragment: CocktailsFragment)
}