package com.example.fooddeliveryapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "menu")
data class MenuItem(
    @PrimaryKey(autoGenerate = true)
    val iddish: Int = 0,

    @SerializedName("namedish")
    val nameDish: String,

    @SerializedName("price")
    val price: Double,

    @SerializedName("description")
    val description: String?
)
