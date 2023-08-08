package com.example.coctailsapp.ui.cocktails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailsapp.data.db.CocktailsDatabase
import com.example.coctailsapp.ui.cocktails.model.CocktailItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CocktailsViewModel @Inject constructor(
    private val db: CocktailsDatabase
) : ViewModel() {
    private val database = db.cocktailsDao()
    private val _cocktailList = MutableLiveData<List<CocktailItem>>(emptyList())
    val cocktailList: LiveData<List<CocktailItem>> get() = _cocktailList

    fun getCocktails() {
        viewModelScope.launch(Dispatchers.IO) {
            _cocktailList.postValue(database.getCocktails().map { it.toUi() })
        }
    }
}