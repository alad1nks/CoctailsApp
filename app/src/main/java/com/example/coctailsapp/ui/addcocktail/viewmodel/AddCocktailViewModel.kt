package com.example.coctailsapp.ui.addcocktail.viewmodel

import androidx.core.graphics.createBitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailsapp.data.db.CocktailsDatabase
import com.example.coctailsapp.data.entities.CocktailEntity
import com.example.coctailsapp.delegate.DelegateAdapterItem
import com.example.coctailsapp.ui.addcocktail.model.ButtonPlusItem
import com.example.coctailsapp.ui.addcocktail.model.IngredientItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddCocktailViewModel @Inject constructor(
    private val db: CocktailsDatabase
) : ViewModel() {
    private val database = db.cocktailsDao()

    private val _delegateList = MutableLiveData<List<DelegateAdapterItem>>(listOf(ButtonPlusItem()))
    val delegateList: LiveData<List<DelegateAdapterItem>> get() = _delegateList

    private val _title = MutableLiveData("")
    val title: LiveData<String> get() = _title

    private val _description = MutableLiveData("")
    val description: LiveData<String> get() = _description

    private val ingredients = MutableLiveData<List<IngredientItem>>(emptyList())

    private val _recipe = MutableLiveData("")
    val recipe: LiveData<String> get() = _recipe

    fun changeTitle(text: String) {
        _title.value = text
    }

    fun changeDescription(text: String) {
        _description.value = text
    }

    fun changeRecipe(text: String) {
        _recipe.value = text
    }

    fun wipe() {
        _delegateList.value = listOf(ButtonPlusItem())
        _title.value = ""
        _description.value = ""
        _recipe.value = ""
        ingredients.value = emptyList()
    }

    fun addRecipe(name: String) {
        val newDelegateItems: MutableList<DelegateAdapterItem> = _delegateList.value?.toMutableList() ?: mutableListOf()
        val newIngredients = ingredients.value?.toMutableList() ?: mutableListOf()
        newDelegateItems.add(newDelegateItems.size - 1, IngredientItem(newDelegateItems.size - 1, name))
        newIngredients.add(IngredientItem(newDelegateItems.size, name))
        _delegateList.value = newDelegateItems.toList()
        ingredients.value = newIngredients.toList()
    }

    fun addCocktail() {
        viewModelScope.launch(Dispatchers.IO) {
            database.insertCocktail(CocktailEntity(
                title = title.value!!,
                description = description.value!!,
                ingredients = ingredients.value!!.map { it.toEntity() },
                recipe = recipe.value!!,
                image = createBitmap(1, 1)))
        }
    }
}