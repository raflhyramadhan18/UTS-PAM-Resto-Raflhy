package com.example.resto

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView // <-- TAMBAHKAN IMPORT INI
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class AlamatActivity : AppCompatActivity() {

    private var currentUsername: String = "User"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alamat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data (ini tetap sama)
        currentUsername = intent.getStringExtra("EXTRA_USERNAME") ?: "User"

        // --- TAMBAHKAN KODE TOMBOL BACK ---
        val ivBackAlamat: ImageView = findViewById(R.id.ivBackAlamat)
        ivBackAlamat.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Kembali ke OrderFragment
        }
        // --- BATAS KODE TOMBOL BACK ---

        // Cari Views (ID ini semua sama, jadi aman)
        val etNama: TextInputEditText = findViewById(R.id.etNamaLengkapAlamat)
        val etAlamat: TextInputEditText = findViewById(R.id.etAlamat)
        val etPatokan: TextInputEditText = findViewById(R.id.etPatokan)
        val btnOrderKirim: MaterialButton = findViewById(R.id.btnOrderKirim)

        // Aksi tombol (Logika ini tetap sama)
        btnOrderKirim.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val alamat = etAlamat.text.toString().trim()
            val patokan = etPatokan.text.toString().trim()

            if (nama.isEmpty() || alamat.isEmpty() || patokan.isEmpty()) {
                Toast.makeText(this, "Semua field alamat wajib diisi!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SuccessActivity::class.java)
                intent.putExtra("EXTRA_USERNAME", currentUsername)
                startActivity(intent)
                finish()
            }
        }
    }
}