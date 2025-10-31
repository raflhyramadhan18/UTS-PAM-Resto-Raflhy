package com.example.resto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private var currentUsername: String = "User"

    // --- PERUBAHAN 1: Tambahkan variabel ini ---
    // Variabel untuk menyimpan nama makanan yang dipilih sementara
    private var selectedFoodName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        currentUsername = intent.getStringExtra("EXTRA_USERNAME") ?: "User"

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // --- PERUBAHAN 2: Update listener Anda ---
        bottomNavigation.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.navigation_home -> {
                    selectedFragment = HomeFragment()
                    selectedFragment.arguments = Bundle().apply {
                        putString("EXTRA_USERNAME", currentUsername)
                    }
                    // Reset nama makanan jika kembali ke home
                    selectedFoodName = null
                }
                R.id.navigation_order -> {
                    selectedFragment = OrderFragment()

                    // Tentukan nama makanan:
                    // Jika selectedFoodName tidak null (karena klik item), pakai itu.
                    // Jika null (karena klik tab), pakai "Pilih makanan dulu".
                    val foodName = selectedFoodName ?: "Pilih makanan dulu"

                    selectedFragment.arguments = Bundle().apply {
                        putString("EXTRA_USERNAME", currentUsername)
                        putString("EXTRA_FOOD_NAME", foodName)
                    }
                }
                R.id.navigation_profile -> {
                    selectedFragment = ProfileFragment()
                    // Kirim username ke ProfileFragment
                    selectedFragment.arguments = Bundle().apply {
                        putString("EXTRA_USERNAME", currentUsername)
                    }
                }
            }
            // Ganti fragment
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit()
            }
            true
        }

        // Tampilkan HomeFragment sebagai default (ini sudah benar)
        if (savedInstanceState == null) {
            val defaultFragment = HomeFragment()
            defaultFragment.arguments = Bundle().apply {
                putString("EXTRA_USERNAME", currentUsername)
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, defaultFragment)
                .commit()
            bottomNavigation.selectedItemId = R.id.navigation_home
        }
    }

    // --- PERUBAHAN 3: Sederhanakan fungsi ini ---
    // Fungsi ini dipanggil dari HomeFragment saat item di-klik
    fun navigateToOrder(food: FoodItem) {
        // 1. Simpan nama makanan yang dipilih ke variabel
        this.selectedFoodName = food.name

        // 2. "Klik" tab Order secara programatis.
        // Ini akan memicu setOnItemSelectedListener, yang sekarang
        // akan menggunakan nama makanan yang sudah kita simpan.
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.navigation_order
    }
}