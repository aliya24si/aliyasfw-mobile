package com.example.aliya_lilac.tugas_pertemuan3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.aliya_lilac.databinding.ActivityWelcomeBinding
import com.example.aliya_lilac.tugas_pertemuan2.BangunRuangActivity
import com.example.aliya_lilac.tugas_pertemuan4.HomeActivity
import com.example.aliya_lilac.tugas_pertemuan4.PharmacyActivity
import com.google.android.material.snackbar.Snackbar
import kotlin.jvm.java

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val judul = binding.tvWelcomeTitle.text.toString()

        // Navigasi ke Bangun Ruang (Main2)
        binding.btnBangunRuang.setOnClickListener {
            val intent = Intent(this, BangunRuangActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", judul)
            startActivity(intent)
        }

        // Navigasi ke Home
        binding.btnGoHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "Dashboard Home")
            startActivity(intent)
        }

        // Navigasi ke Pharmacy
        binding.btnGoPharmacy.setOnClickListener {
            val intent = Intent(this, PharmacyActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "Daftar Apotek")
            startActivity(intent)
        }

        // Tombol Logout di Pojok Kanan Atas
        binding.btnActionLogout.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi")
            builder.setMessage("Ingin keluar dari aplikasi?")

            builder.setPositiveButton("Iya") { _, _ ->
                // Pindah ke Login (Main3)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            builder.setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
                Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
            }
            builder.show()
        }
    }
}