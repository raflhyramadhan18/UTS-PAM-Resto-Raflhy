package com.example.resto

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class OrderFragment : Fragment() {

    private var username: String = "User"
    private var foodName: String = "Belum ada pesanan"

    private val DEFAULT_FOOD_NAME_1 = "Belum ada pesanan"
    private val DEFAULT_FOOD_NAME_2 = "Pilih makanan dulu"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString("EXTRA_USERNAME", "User")
            foodName = it.getString("EXTRA_FOOD_NAME", DEFAULT_FOOD_NAME_1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        // --- SESUAIKAN DENGAN ID BARU ---
        val tvOrderWelcome: TextView = view.findViewById(R.id.tvOrderWelcome)
        val tvSelectedItem: TextView = view.findViewById(R.id.tvSelectedItemName) // <-- ID BARU
        val btnKirim: MaterialButton = view.findViewById(R.id.btnKirimAlamat) // <-- ID BARU
        // --- BATAS PENYESUAIAN ---

        tvOrderWelcome.text = "Halo, $username"
        tvSelectedItem.text = foodName

        btnKirim.setOnClickListener {
            if (foodName == DEFAULT_FOOD_NAME_1 || foodName == DEFAULT_FOOD_NAME_2) {
                Toast.makeText(context, "Silakan pilih makanan terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(activity, AlamatActivity::class.java)
                intent.putExtra("EXTRA_USERNAME", username)
                intent.putExtra("EXTRA_FOOD_NAME", foodName)
                startActivity(intent)
            }
        }

        return view
    }
}