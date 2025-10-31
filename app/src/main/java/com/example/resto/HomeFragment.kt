package com.example.resto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView // <-- PASTIKAN IMPORT INI ADA
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    // Variabel untuk menampung 'username'
    private var username: String = "User"

    // Variabel untuk UI
    private lateinit var tvHomeWelcome: TextView // <-- INI DIA
    private lateinit var rvFood: RecyclerView
    private lateinit var foodAdapter: FoodAdapter
    private var foodList = mutableListOf<FoodItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ambil username dari arguments yang dikirim HomeActivity
        arguments?.let {
            username = it.getString("EXTRA_USERNAME", "User")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // --- INI PERBAIKANNYA ---
        // 1. Cari TextView baru berdasarkan ID
        tvHomeWelcome = view.findViewById(R.id.tvHomeWelcome)

        // 2. Set teksnya dengan username
        tvHomeWelcome.text = "Selamat Datang, $username"
        // --- BATAS PERBAIKAN ---

        // Inisialisasi RecyclerView
        rvFood = view.findViewById(R.id.rvFood)

        // Siapkan data makanan dan adapter
        setupRecyclerView()
        loadFoodData() // Panggil fungsi untuk mengisi data

        return view
    }

    private fun setupRecyclerView() {
        // Logika ini sudah benar, sesuai dengan FoodAdapter Anda
        foodAdapter = FoodAdapter(foodList) { selectedFood ->
            // Panggil fungsi di HomeActivity untuk pindah ke OrderFragment
            (activity as? HomeActivity)?.navigateToOrder(selectedFood)
        }

        rvFood.layoutManager = LinearLayoutManager(context)
        rvFood.adapter = foodAdapter
    }

    // Fungsi untuk mengisi 10 data makanan (dummy)
    private fun loadFoodData() {
        foodList.clear()

        // Ganti 'R.drawable.nama_gambar' dengan ID gambar Anda
        foodList.add(FoodItem("Combro Bandung", "Combro adalah makanan dari tepung dan rasanya pedas.", R.drawable.combro))
        foodList.add(FoodItem("Batagor Bandung", "Batagor adalah makanan dari tepung dan rasanya gurih.", R.drawable.batagor))
        foodList.add(FoodItem("Seblak Ceker", "Seblak ceker pedas dengan bumbu khas.", R.drawable.seblak))
        foodList.add(FoodItem("Nasi Timbel", "Nasi dibungkus daun pisang dengan lauk lengkap.", R.drawable.nasi_timbel))
        foodList.add(FoodItem("Karedok", "Salad sayuran segar dengan bumbu kacang.", R.drawable.karedok))
        foodList.add(FoodItem("Lotek", "Sayuran rebus dengan bumbu kacang.", R.drawable.lotek))
        foodList.add(FoodItem("Surabi", "Serabi dengan topping oncom.", R.drawable.surabi))
        foodList.add(FoodItem("Cireng Isi", "Aci digoreng dengan isian ayam pedas.", R.drawable.cireng))
        foodList.add(FoodItem("Mie Kocok", "Mie kuning dengan kikil sapi dan kuah kaldu.", R.drawable.mie_kocok))
        foodList.add(FoodItem("Es Campur", "Minuman manis dengan kental manis dan buah.", R.drawable.es_campur))

        foodAdapter.notifyDataSetChanged()
    }
}