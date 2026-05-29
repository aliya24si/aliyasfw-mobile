package com.example.aliya_lilac

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TabPenerimaFragment : Fragment(R.layout.fragment_tab_penerima) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listData = listOf(
            PenerimaBantuanModel("1", "Bantuan Untuk Orang Kurang Mampu", "Hendra Mansur", "Layak menerima bantuan", "https://picsum.photos/seed/man1/300/300"),
            PenerimaBantuanModel("2", "Program Keluarga Harapan", "Nabila Oktaviani", "Layak menerima bantuan", "https://picsum.photos/seed/woman2/300/300"),
            PenerimaBantuanModel("3", "Bantuan Pangan Non Tunai", "Maida Olivia Kuswandari M.M.", "Layak menerima bantuan", "https://picsum.photos/seed/woman3/300/300"),
            PenerimaBantuanModel("4", "Bantuan Untuk Orang Kurang Mampu", "Kartika Andriani S.IP", "Layak menerima bantuan", "https://picsum.photos/seed/woman4/300/300"),
            PenerimaBantuanModel("5", "Bantuan Untuk Orang Kurang Mampu", "Rini Indah Safitri S.Pd", "Layak menerima bantuan", "https://picsum.photos/seed/woman5/300/300"),
            PenerimaBantuanModel("6", "Bantuan Panti Asuhan", "Nasrullah Firmansyah S.Gz", "Layak menerima bantuan", "https://picsum.photos/seed/man6/300/300"),
            PenerimaBantuanModel("7", "Bantuan Langsung Tunai Desa", "Mila Paulin Anggraini M.Kom.", "Layak menerima bantuan", "https://picsum.photos/seed/woman7/300/300")
        )

        val rv = view.findViewById<RecyclerView>(R.id.rvPenerimaTab)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = PenerimaBantuanAdapter(listData)
    }
}