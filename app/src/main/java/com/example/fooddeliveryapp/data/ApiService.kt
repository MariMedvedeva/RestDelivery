package com.example.fooddeliveryapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Path

interface ApiService {

    // Получение списка всех заказов
    @GET("orders")
    fun getAllOrders(): Call<List<Order>>

    // Создание нового заказа
    @POST("orders")
    fun createOrder(@Body order: Order): Call<Order>

    // Получение меню
    @GET("menu")
    fun getMenu(): Call<List<MenuItem>>
}