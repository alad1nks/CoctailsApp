package com.example.coctailsapp.di

import androidx.lifecycle.ViewModel
import com.example.coctailsapp.ui.cocktailinfo.viewmodel.CocktailInfoViewModel
import com.example.coctailsapp.ui.cocktails.viewmodel.CocktailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CocktailInfoModule {
    @Binds
    @IntoMap
    @ViewModelKey(CocktailInfoViewModel::class)
    abstract fun bindViewModel(viewModel: CocktailInfoViewModel): ViewModel
}