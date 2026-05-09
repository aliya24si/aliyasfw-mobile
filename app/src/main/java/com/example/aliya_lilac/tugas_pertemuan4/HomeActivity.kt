package com.example.aliya_lilac.tugas_pertemuan4

import android.os.Bundle
import android.widget.ImageView // Import ini penting!
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aliya_lilac.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

        // 1. Inisialisasi TextView (untuk tangkap data)
        val tvName = findViewById<TextView>(R.id.tvUserName)
        val tvSub = findViewById<TextView>(R.id.tvUserSubTitle)

        // 2. Tangkap data dari Intent
        val judulIntent = intent.getStringExtra("EXTRA_JUDUL")
        val descIntent = intent.getStringExtra("EXTRA_DESC")

        if (judulIntent != null) tvName.text = judulIntent
        if (descIntent != null) tvSub.text = descIntent

        // --- INI BAGIAN YANG KAMU MAU ---
        // 3. Inisialisasi tombol back (ImageView)
        val btnBack = findViewById<ImageView>(R.id.btnBackHome)

        // 4. Aksi saat tombol back ditekan
        btnBack.setOnClickListener {
            // Cukup panggil finish()
            finish()
        }
        // -------------------------------
    }
}