package com.example.fooddeliveryapp.ui.theme

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.viewmodel.OrderViewModel

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding
    private val orderViewModel: OrderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Настройка RecyclerView для списка заказов
        val adapter = OrderAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Наблюдение за списком заказов
        orderViewModel.orders.observe(this, { orders ->
            orders?.let {
                adapter.submitList(it)
            }
        })

        // Загружаем заказы при запуске активности
        orderViewModel.loadOrders()

        // Обработчик создания нового заказа
        binding.btnCreateOrder.setOnClickListener {
            val newOrder = OrderModel(
                clientId = 1, // пример, нужно брать данные от пользователя
                statusId = 1,
                orderDate = "2024-11-22",
                price = 100.0
            )
            orderViewModel.createOrder(newOrder)
            Toast.makeText(this, "Order Created", Toast.LENGTH_SHORT).show()
        }
    }
}