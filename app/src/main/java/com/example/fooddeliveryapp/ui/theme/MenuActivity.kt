package com.example.fooddeliveryapp.ui.theme

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.viewmodel.MenuViewModel

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private val menuViewModel: MenuViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Настройка RecyclerView для списка меню
        val adapter = MenuAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Наблюдение за изменениями в меню
        menuViewModel.menuItems.observe(this, { menuItems ->
            menuItems?.let {
                adapter.submitList(it)
            }
        })

        // Загружаем меню при запуске активности
        menuViewModel.loadMenu()
    }
}