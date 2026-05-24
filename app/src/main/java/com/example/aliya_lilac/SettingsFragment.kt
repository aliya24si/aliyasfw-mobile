package com.example.aliya_lilac

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    // Membuat kumpulan data teks beserta deskripsinya (SimpleAdapter Requirement)
    private val settingsData = listOf(
        mapOf("title" to "Kebijakan Privasi", "desc" to "Pengaturan data dan privasi warga Bina Desa"),
        mapOf("title" to "Ketentuan Layanan", "desc" to "Aturan syarat penggunaan sistem bantuan sosial"),
        mapOf("title" to "Pusat Bantuan", "desc" to "Hubungi admin pengembang desa jika terjadi kendala"),
        mapOf("title" to "Versi Aplikasi", "desc" to "Bina Desa Mobile v1.0.0-production")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listViewSettings: ListView = view.findViewById(R.id.listViewSettings)

        // Map kunci array string ke id text internal simple_list_item_2 milik Android OS
        val adapter = SimpleAdapter(
            requireContext(),
            settingsData,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        listViewSettings.adapter = adapter

        // Logika event klik item daftar list
        listViewSettings.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = settingsData[position]
            val title = selectedItem["title"]
            Toast.makeText(requireContext(), "Membuka halaman: $title", Toast.LENGTH_SHORT).show()
        }
    }
}