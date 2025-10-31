package com.example.resto

// Data class sederhana untuk menyimpan data makanan
data class FoodItem(
    val name: String,
    val description: String,
    val imageResId: Int // Kita pakai Int untuk ID drawable
)