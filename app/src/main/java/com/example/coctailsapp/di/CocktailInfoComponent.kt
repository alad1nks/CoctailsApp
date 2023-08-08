package com.example.coctailsapp.di

import com.example.coctailsapp.ui.cocktailinfo.view.CocktailInfoFragment
import com.example.coctailsapp.ui.cocktails.view.CocktailsFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        CocktailInfoModule::class
    ]
)
interface CocktailInfoComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): CocktailInfoComponent
    }
    fun inject(fragment: CocktailInfoFragment)
}