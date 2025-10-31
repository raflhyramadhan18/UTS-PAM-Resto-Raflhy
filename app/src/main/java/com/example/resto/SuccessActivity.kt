package com.example.resto

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation // <-- TAMBAHKAN IMPORT
import android.view.animation.AnimationUtils // <-- TAMBAHKAN IMPORT
import android.widget.ImageView // <-- TAMBAHKAN IMPORT
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_success)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- TAMBAHKAN KODE ANIMASI DI SINI ---

        // 1. Cari ImageView
        val ivSuccessCheck: ImageView = findViewById(R.id.ivSuccessCheck)

        // 2. Load animasi 'pop_in.xml'
        val animPopIn = AnimationUtils.loadAnimation(this, R.anim.pop_in)

        // 3. Jalankan animasi pada ImageView
        ivSuccessCheck.startAnimation(animPopIn)

        // --- BATAS KODE ANIMASI ---

        // Cari tombol 'Kembali ke Home' (ID-nya 'btnKembaliHome')
        val btnKembaliHome: MaterialButton = findViewById(R.id.btnKembaliHome)

        btnKembaliHome.setOnClickListener {
            // Logika Intent (ini sudah benar)
            Toast.makeText(this, "Order berhasil terkirim", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}