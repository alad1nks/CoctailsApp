package com.example.coctailsapp.di

import androidx.lifecycle.ViewModel
import com.example.coctailsapp.ui.cocktails.viewmodel.CocktailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CocktailsModule {
    @Binds
    @IntoMap
    @ViewModelKey(CocktailsViewModel::class)
    abstract fun bindViewModel(viewModel: CocktailsViewModel): ViewModel
}