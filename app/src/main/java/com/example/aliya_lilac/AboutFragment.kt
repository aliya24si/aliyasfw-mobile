package com.example.aliya_lilac

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.aliya_lilac.utils.PermissionHelper
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.ChipGroup

class AboutFragment : Fragment(R.layout.fragment_about) {

    private val requestNotificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(requireContext(), "Izin notifikasi aktif!", Toast.LENGTH_SHORT).show()
                bukaFormPengaduan()
            } else {
                Toast.makeText(requireContext(), "Izin ditolak, Anda tidak akan menerima notifikasi pengaduan.", Toast.LENGTH_LONG).show()
                bukaFormPengaduan()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chipGroupAbout: ChipGroup = view.findViewById(R.id.chipGroupAbout)
        val tvDetailTitle: TextView = view.findViewById(R.id.tvDetailTitle)
        val tvDetailDesc: TextView = view.findViewById(R.id.tvDetailDesc)
        val btnKeFormPengaduan: MaterialButton = view.findViewById(R.id.btnKeFormPengaduan)

        // Inisialisasi Tombol Penyaluran Bantuan Baru
        val btnKePenyaluranBantuan: MaterialButton = view.findViewById(R.id.btnKePenyaluranBantuan)

        chipGroupAbout.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            when (selectedChipId) {
                R.id.chipMonitoring -> {
                    tvDetailTitle.text = "Detail Fitur Monitoring"
                    tvDetailDesc.text = "Memantau status dan grafik real-time perkembangan distribusi bantuan sosial agar tepat sasaran bagi warga desa."
                }
                R.id.chipPelaporan -> {
                    tvDetailTitle.text = "Detail Fitur Pelaporan"
                    tvDetailDesc.text = "Memudahkan admin dan pengurus desa untuk melaporkan penyaluran logistik secara transparan langsung dari aplikasi."
                }
                R.id.chipLayanan -> {
                    tvDetailTitle.text = "Detail Layanan Online"
                    tvDetailDesc.text = "Integrasi penuh dengan platform web desktop untuk memverifikasi data lapangan dan melihat riwayat penyaluran secara detail."
                }
            }
        }

        btnKeFormPengaduan.setOnClickListener {
            if (PermissionHelper.isNotificationPermissionRequired()) {
                val permission = Manifest.permission.POST_NOTIFICATIONS
                if (!PermissionHelper.hasPermission(requireContext(), permission)) {
                    PermissionHelper.requestPermission(requestNotificationPermissionLauncher, permission)
                } else {
                    bukaFormPengaduan()
                }
            } else {
                bukaFormPengaduan()
            }
        }

        // Klik ke Fitur Penyaluran Bantuan
        btnKePenyaluranBantuan.setOnClickListener {
            val intent = Intent(requireContext(), PenyaluranBantuanActivity::class.java)
            startActivity(intent)
        }
    }

    private fun bukaFormPengaduan() {
        val intent = Intent(requireContext(), PengaduanFormActivity::class.java)
        startActivity(intent)
    }
}