package com.example.aliya_lilac

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TabProgramFragment : Fragment(R.layout.fragment_tab_program) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listData = listOf(
            ProgramBantuanModel("PB009", "Bantuan Sosial", "2025", "Rp 2.560.000", "https://picsum.photos/seed/bansos1/300/300"),
            ProgramBantuanModel("PB001", "Bantuan Langsung Tunai Desa", "2024", "Rp 30.000.000", "https://picsum.photos/seed/blt2/300/300"),
            ProgramBantuanModel("PB002", "Program Keluarga Harapan", "2024", "Rp 40.000.000", "https://picsum.photos/seed/pkh3/300/300"),
            ProgramBantuanModel("PB003", "Bantuan Pangan Non Tunai", "2024", "Rp 25.000.000", "https://picsum.photos/seed/pangan4/300/300"),
            ProgramBantuanModel("PB004", "Bantuan Modal UMKM", "2024", "Rp 50.000.000", "https://picsum.photos/seed/umkm5/300/300"),
            ProgramBantuanModel("PB005", "Beasiswa Pendidikan Warga Tidak Mampu", "2024", "Rp 35.000.000", "https://picsum.photos/seed/edu6/300/300"),
            ProgramBantuanModel("PB006", "Bantuan Untuk Orang Kurang Mampu", "2024", "Rp 30.000.000", "https://picsum.photos/seed/care7/300/300"),
            ProgramBantuanModel("PB007", "Bantuan Panti Asuhan", "2024", "Rp 20.000.000", "https://picsum.photos/seed/orphan8/300/300"),
            ProgramBantuanModel("PB008", "Bantuan Bencana Alam", "2024", "Rp 45.000.000", "https://picsum.photos/seed/nature9/300/300")
        )

        val rv = view.findViewById<RecyclerView>(R.id.rvProgramTab)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = ProgramBantuanAdapter(listData)
    }
}