package com.example.coctailsapp.di

import androidx.lifecycle.ViewModel
import com.example.coctailsapp.ui.addcocktail.viewmodel.AddCocktailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AddIngredientModule {
    @Binds
    @IntoMap
    @ViewModelKey(AddCocktailViewModel::class)
    abstract fun bindViewModel(viewModel: AddCocktailViewModel): ViewModel
}