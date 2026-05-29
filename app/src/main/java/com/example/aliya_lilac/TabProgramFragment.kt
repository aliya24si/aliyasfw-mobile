package com.example.aliya_lilac

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TabProgramFragment : Fragment(R.layout.fragment_tab_program) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data diisi sesuai persis dengan screenshot foto daftar program milikmu
        val listData = listOf(
            ProgramBantuanModel("PB009", "Bantuan Sosial", "2025", "Rp 2.560.000"),
            ProgramBantuanModel("PB001", "Bantuan Langsung Tunai Desa", "2024", "Rp 30.000.000"),
            ProgramBantuanModel("PB002", "Program Keluarga Harapan", "2024", "Rp 40.000.000"),
            ProgramBantuanModel("PB003", "Bantuan Pangan Non Tunai", "2024", "Rp 25.000.000"),
            ProgramBantuanModel("PB004", "Bantuan Modal UMKM", "2024", "Rp 50.000.000"),
            ProgramBantuanModel("PB005", "Beasiswa Pendidikan Warga Tidak Mampu", "2024", "Rp 35.000.000"),
            ProgramBantuanModel("PB006", "Bantuan Untuk Orang Kurang Mampu", "2024", "Rp 30.000.000"),
            ProgramBantuanModel("PB007", "Bantuan Panti Asuhan", "2024", "Rp 20.000.000"),
            ProgramBantuanModel("PB008", "Bantuan Bencana Alam", "2024", "Rp 45.000.000")
        )

        val rv = view.findViewById<RecyclerView>(R.id.rvProgramTab)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = ProgramBantuanAdapter(listData)
    }
}