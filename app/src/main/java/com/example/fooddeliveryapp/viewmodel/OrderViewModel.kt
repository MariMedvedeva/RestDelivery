package com.example.fooddeliveryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddeliveryapp.data.DataRepository
import com.example.fooddeliveryapp.model.OrderModel
import kotlinx.coroutines.launch

class OrderViewModel(private val repository: DataRepository) : ViewModel() {

    private val _orders = MutableLiveData<List<OrderModel>>()
    val orders: LiveData<List<OrderModel>> get() = _orders

    // Метод для загрузки заказов из базы данных или сервера
    fun loadOrders() {
        viewModelScope.launch {
            // Загрузка данных из базы или сети
            val ordersFromDb = repository.getOrdersFromDatabase()
            val orderModels = ordersFromDb.map {
                OrderModel(
                    it.idorder,
                    it.clientId,
                    it.statusId,
                    it.orderDate,
                    it.price
                )
            }
            _orders.value = orderModels
        }
    }

    // Метод для создания нового заказа
    fun createOrder(order: OrderModel) {
        viewModelScope.launch {
            repository.saveOrderToServer(order)
            loadOrders()  // Перезагружаем список после добавления нового заказа
        }
    }
}
