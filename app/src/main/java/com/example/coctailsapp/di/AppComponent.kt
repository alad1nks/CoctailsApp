package com.example.coctailsapp.di

import android.content.Context
import com.example.coctailsapp.MainActivity
import com.example.coctailsapp.ui.addcocktail.view.AddCocktailFragment
import com.example.coctailsapp.ui.addcocktail.view.AddIngredientDialogFragment
import com.example.coctailsapp.ui.cocktails.view.CocktailsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppSubcomponents::class,
        DatabaseModule::class,
        ViewModelBuilderModule::class,
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun addCocktailComponent(): AddCocktailComponent.Factory
    fun addIngredientComponent(): AddIngredientComponent.Factory
    fun cocktailsComponent(): CocktailsComponent.Factory
    fun cocktailInfoComponent(): CocktailInfoComponent.Factory
}