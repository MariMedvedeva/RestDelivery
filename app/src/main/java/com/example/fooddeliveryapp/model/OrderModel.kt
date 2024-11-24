package com.example.fooddeliveryapp.model

data class OrderModel(
    val idorder: Int,
    val clientId: Int,
    val statusId: Int,
    val orderDate: String,
    val price: Double
)