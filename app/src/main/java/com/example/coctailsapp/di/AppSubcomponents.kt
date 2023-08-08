package com.example.coctailsapp.di

import dagger.Module

@Module(
    subcomponents = [
        AddCocktailComponent::class,
        AddIngredientComponent::class,
        CocktailsComponent::class,
        CocktailInfoComponent::class
    ]
)
object AppSubcomponents