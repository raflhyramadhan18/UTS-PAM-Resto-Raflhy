package com.example.resto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton // <-- TAMBAHKAN IMPORT INI

class FoodAdapter(
    private val foodList: List<FoodItem>,
    private val onItemClick: (FoodItem) -> Unit // Ini adalah listener untuk klik
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    // Kelas ViewHolder untuk menyimpan referensi view
    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImage: ImageView = itemView.findViewById(R.id.ivFoodImage)
        val tvName: TextView = itemView.findViewById(R.id.tvFoodName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvFoodDescription)

        // <-- TAMBAHKAN REFERENSI UNTUK TOMBOL BARU -->
        val btnOrderNow: MaterialButton = itemView.findViewById(R.id.btnOrderNow)
    }

    // Membuat ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false) // Ini sudah benar
        return FoodViewHolder(view)
    }

    // Mendapatkan jumlah item
    override fun getItemCount(): Int = foodList.size

    // Menghubungkan data (dari foodList) ke view (di ViewHolder)
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]

        holder.tvName.text = food.name
        holder.tvDescription.text = food.description
        holder.ivImage.setImageResource(food.imageResId) // Set gambar

        // <-- INI YANG BERUBAH -->
        // Aksi klik sekarang ada di TOMBOL, bukan di seluruh card
        holder.btnOrderNow.setOnClickListener {
            onItemClick(food)
        }

        // Hapus listener lama jika ada:
        // holder.itemView.setOnClickListener { ... } // <-- HAPUS INI
    }
}