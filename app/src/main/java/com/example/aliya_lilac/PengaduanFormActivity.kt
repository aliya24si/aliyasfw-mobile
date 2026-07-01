package com.example.aliya_lilac

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.aliya_lilac.data.AppDatabase
import com.example.aliya_lilac.data.entity.PengaduanEntity
import com.example.aliya_lilac.databinding.ActivityPengaduanFormBinding
import com.example.aliya_lilac.utils.NotificationHelper
import com.example.aliya_lilac.utils.ReminderHelper
import kotlinx.coroutines.launch
import java.util.Calendar

class PengaduanFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPengaduanFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPengaduanFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        // Set up Toolbar agar bisa kembali
        binding.toolbarPengaduan.setNavigationIcon(android.R.drawable.ic_menu_revert)
        binding.toolbarPengaduan.setNavigationOnClickListener { finish() }

        binding.btnSimpanPengaduan.setOnClickListener {
            simpanPengaduan()
        }
    }

    private fun simpanPengaduan() {
        val judul = binding.etJudulPengaduan.text.toString()
        val deskripsi = binding.etDeskripsiPengaduan.text.toString()
        val menitStr = binding.etReminderMenit.text.toString()

        if (judul.isBlank() || deskripsi.isBlank() || menitStr.isBlank()) {
            Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            return
        }

        val menit = menitStr.toInt()

        lifecycleScope.launch {
            // 1. Simpan ke Room Database
            val pengaduan = PengaduanEntity(
                judul = judul,
                deskripsi = deskripsi,
                tanggal = System.currentTimeMillis()
            )
            db.pengaduanDao().insertPengaduan(pengaduan)

            // 2. Munculkan Local Notification Instan
            val intentKeDaftar = Intent(this@PengaduanFormActivity, DaftarPengaduanActivity::class.java)
            NotificationHelper.showNotification(
                this@PengaduanFormActivity,
                "Aduan Terkirim!",
                "Aduan '$judul' telah berhasil disimpan di sistem Bina Desa.",
                intentKeDaftar
            )

            // 3. Set Reminder (AlarmManager) sesuai input menit
            val calendar = Calendar.getInstance().apply {
                add(Calendar.MINUTE, menit)
            }

            ReminderHelper.setReminder(
                context = this@PengaduanFormActivity,
                hour = calendar.get(Calendar.HOUR_OF_DAY),
                minute = calendar.get(Calendar.MINUTE),
                title = "Reminder Tindak Lanjut Aduan",
                message = "Waktunya mengecek status aduan: $judul",
                targetActivity = DaftarPengaduanActivity::class.java // Tetap biarkan jika di Helper masih ada parameternya
            )

            Toast.makeText(this@PengaduanFormActivity, "Berhasil! Reminder diset $menit menit lagi", Toast.LENGTH_LONG).show()
            finish() // Tutup halaman
        }
    }
}