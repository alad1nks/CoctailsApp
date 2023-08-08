package com.example.coctailsapp.ui.cocktailinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailsapp.data.db.CocktailsDatabase
import com.example.coctailsapp.data.entities.CocktailEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CocktailInfoViewModel @Inject constructor(
    private val db: CocktailsDatabase
) : ViewModel() {
    private val database = db.cocktailsDao()

    private val _cocktail = MutableLiveData<CocktailEntity>()
    val cocktail: LiveData<CocktailEntity> get() = _cocktail

    fun getCocktail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _cocktail.postValue(database.getCocktails(id))
        }
    }
}