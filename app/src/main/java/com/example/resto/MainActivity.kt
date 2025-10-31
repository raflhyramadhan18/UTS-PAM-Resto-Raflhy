package com.example.resto

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import android.widget.ImageView
import android.widget.TextView
import android.view.animation.Animation
import android.view.animation.AnimationUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Cari Views
        val ivLogo: ImageView = findViewById(R.id.ivLogo)
        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvSubtitle: TextView = findViewById(R.id.tvSubtitle)
        val btnStartNow: MaterialButton = findViewById(R.id.btnStartNow)

        // 2. Load animasi
        val animLogo = AnimationUtils.loadAnimation(this, R.anim.logo_anim) // <-- INI YANG DIUBAH
        val animSlideUp = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top)

        // 3. Terapkan animasi
        ivLogo.startAnimation(animLogo) // <-- INI YANG DIUBAH
        tvTitle.startAnimation(animSlideUp)
        tvSubtitle.startAnimation(animSlideUp)
        btnStartNow.startAnimation(animSlideUp)

        // Atur penundaan agar animasi tidak bertumpuk terlalu cepat
        // (opsional, untuk efek lebih smooth)
        tvTitle.animation.startOffset = 200 // Mulai 0.2 detik setelah logo
        tvSubtitle.animation.startOffset = 400 // Mulai 0.4 detik setelah logo
        btnStartNow.animation.startOffset = 600 // Mulai 0.6 detik setelah logo


        // Kode untuk pindah halaman (tetap sama)
        btnStartNow.setOnClickListener {
            val intent = Intent(this, Screen2Activity::class.java)
            startActivity(intent)
        }
    }
}