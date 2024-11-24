package com.example.fooddeliveryapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val idorder: Int = 0,

    @SerializedName("clientid")
    val clientId: Int,

    @SerializedName("statusid")
    val statusId: Int,

    @SerializedName("orderdate")
    val orderDate: String,

    @SerializedName("price")
    val price: Double
)