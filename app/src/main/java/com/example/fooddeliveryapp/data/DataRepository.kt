package com.example.fooddeliveryapp.data

class DataRepository(
    private val apiService: ApiService,
    private val orderDao: OrderDao
) {

    // Получить все заказы с сервера
    suspend fun getOrdersFromServer(): List<Order> {
        return apiService.getAllOrders().execute().body() ?: emptyList()
    }
/*
    // Получить все заказы из локальной базы данных
    suspend fun getOrdersFromDatabase(): List<Order> {
        return orderDao.getAllOrders()
    }
*/
    // Сохранить заказ в локальной базе данных
    suspend fun saveOrderToDatabase(order: Order) {
        orderDao.insertOrder(order)
    }

    // Сохранить заказ на сервере
    suspend fun saveOrderToServer(order: Order) {
        apiService.createOrder(order).execute()
    }
}