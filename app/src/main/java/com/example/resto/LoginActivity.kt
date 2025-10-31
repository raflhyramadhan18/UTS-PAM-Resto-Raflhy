package com.example.resto

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton // <-- IMPORT INI
import com.google.android.material.textfield.TextInputEditText // <-- IMPORT INI
import android.content.Intent

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- TAMBAHKAN KODE TOMBOL BACK ---
        val ivBackLogin: ImageView = findViewById(R.id.ivBackLogin)
        ivBackLogin.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Kembali ke Activity sebelumnya
        }

        // --- VALIDASI LOGIN ---
        // 1. Cari view berdasarkan ID
        val etUsername: TextInputEditText = findViewById(R.id.etUsername)
        val etPassword: TextInputEditText = findViewById(R.id.etPassword)
        val btnLoginAction: MaterialButton = findViewById(R.id.btnLoginAction)

        // 2. Beri aksi klik pada tombol login
        btnLoginAction.setOnClickListener {
            // 3. Ambil teks dari input field
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // 4. Cek apakah ada yang kosong
            if (username.isEmpty() || password.isEmpty()) {
                // ... (kode error, biarkan)
            } else {
                // JIKA BERHASIL:
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()

                // 1. Buat Intent ke HomeActivity
                val intent = Intent(this, HomeActivity::class.java)

                // 2. Masukkan username ke dalam "extra"
                intent.putExtra("EXTRA_USERNAME", username)

                // 3. Mulai HomeActivity
                startActivity(intent)

                // 4. Tutup LoginActivity
                finish()
            }
        }
        // --- BATAS VALIDASI ---
    }
}