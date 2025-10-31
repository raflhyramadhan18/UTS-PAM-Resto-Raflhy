package com.example.resto

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView // <-- TAMBAHKAN IMPORT
import android.widget.Toast // <-- TAMBAHKAN IMPORT
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class ProfileFragment : Fragment() {

    private var username: String = "User"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ambil username dari HomeActivity
        arguments?.let {
            username = it.getString("EXTRA_USERNAME", "User")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // --- TAMBAHKAN LOGIKA UNTUK INFO PROFIL ---
        val tvProfileName: TextView = view.findViewById(R.id.tvProfileName)
        val tvProfileEmail: TextView = view.findViewById(R.id.tvProfileEmail)

        tvProfileName.text = "Halo, $username"
        tvProfileEmail.text = "$username@gmail.com" // Email placeholder

        // --- TAMBAHKAN LOGIKA UNTUK MENU BARU (PLACEHOLDER) ---
        val tvMenuEdit: TextView = view.findViewById(R.id.tvMenuEditProfile)
        val tvMenuSettings: TextView = view.findViewById(R.id.tvMenuSettings)
        val tvMenuHelp: TextView = view.findViewById(R.id.tvMenuHelp)

        tvMenuEdit.setOnClickListener {
            Toast.makeText(context, "Fitur Edit Profile belum tersedia", Toast.LENGTH_SHORT).show()
        }
        tvMenuSettings.setOnClickListener {
            Toast.makeText(context, "Fitur Pengaturan belum tersedia", Toast.LENGTH_SHORT).show()
        }
        tvMenuHelp.setOnClickListener {
            Toast.makeText(context, "Fitur Pusat Bantuan belum tersedia", Toast.LENGTH_SHORT).show()
        }

        // --- LOGIKA SIGN OUT (INI TETAP SAMA) ---
        val btnSignOut: MaterialButton = view.findViewById(R.id.btnSignOut)
        btnSignOut.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()
        }
        // --- BATAS KODE ---

        return view
    }
}