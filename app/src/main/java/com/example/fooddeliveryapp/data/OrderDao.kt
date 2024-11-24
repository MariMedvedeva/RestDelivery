package com.example.fooddeliveryapp.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import androidx.room.Query

@Dao
interface OrderDao {
    // Вставить новый заказ
    @Insert
    suspend fun insertOrder(order: Order)

    // Обновить заказ
    @Update
    suspend fun updateOrder(order: Order)

    // Удалить заказ
    @Delete
    suspend fun deleteOrder(order: Order)

    /*
    // Получить все заказы
    @Query("SELECT * FROM orders")
    suspend fun getAllOrders(): List<Order>

    // Получить заказ по ID
    @Query("SELECT * FROM orders WHERE idorder = :orderId")
    suspend fun getOrderById(orderId: Int): Order?
*/
}