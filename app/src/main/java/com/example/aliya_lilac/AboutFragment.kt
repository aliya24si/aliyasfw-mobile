package com.example.aliya_lilac

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.chip.ChipGroup

class AboutFragment : Fragment(R.layout.fragment_about) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chipGroupAbout: ChipGroup = view.findViewById(R.id.chipGroupAbout)
        val tvDetailTitle: TextView = view.findViewById(R.id.tvDetailTitle)
        val tvDetailDesc: TextView = view.findViewById(R.id.tvDetailDesc)

        // Logika interaktif ChipGroup
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
    }
}