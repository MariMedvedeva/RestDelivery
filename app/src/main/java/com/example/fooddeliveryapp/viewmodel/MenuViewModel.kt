package com.example.fooddeliveryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddeliveryapp.data.DataRepository
import com.example.fooddeliveryapp.model.MenuItemModel
import kotlinx.coroutines.launch

class MenuViewModel(private val repository: DataRepository) : ViewModel() {

    private val _menuItems = MutableLiveData<List<MenuItemModel>>()
    val menuItems: LiveData<List<MenuItemModel>> get() = _menuItems

    // Метод для загрузки меню из базы данных или сервера
    fun loadMenu() {
        viewModelScope.launch {
            val menuFromDb = repository.getMenuFromDatabase()
            val menuModels = menuFromDb.map {
                MenuItemModel(it.iddish, it.nameDish, it.price, it.description)
            }
            _menuItems.value = menuModels
        }
    }
}