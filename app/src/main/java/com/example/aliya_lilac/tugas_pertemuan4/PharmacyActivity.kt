package com.example.aliya_lilac.tugas_pertemuan4

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aliya_lilac.R

class PharmacyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pharmacy)

        supportActionBar?.hide()

        // 1. Inisialisasi View
        val tvJudul = findViewById<TextView>(R.id.tvTitle)
        val tvSub = findViewById<TextView>(R.id.tvSubtitle)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        // 2. Tangkap data dari Intent (Selamat Datang!)
        val dataJudul = intent.getStringExtra("EXTRA_JUDUL")
        val dataDesc = intent.getStringExtra("EXTRA_DESC")

        // 3. Pasang data ke TextView
        if (dataJudul != null) tvJudul.text = dataJudul
        if (dataDesc != null) tvSub.text = dataDesc

        // --- TOMBOL BACK ---
        btnBack.setOnClickListener {
            // Ini akan menutup PharmacyActivity dan otomatis
            // kembali ke WelcomeActivity (halaman sebelumnya)
            finish()
        }
    }
}