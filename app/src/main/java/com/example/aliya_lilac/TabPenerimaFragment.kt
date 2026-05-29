package com.example.aliya_lilac

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TabPenerimaFragment : Fragment(R.layout.fragment_tab_penerima) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data diisi sesuai persis dengan screenshot foto daftar penerima milikmu
        val listData = listOf(
            PenerimaBantuanModel("1", "Bantuan Untuk Orang Kurang Mampu", "Hendra Mansur", "Layak menerima bantuan"),
            PenerimaBantuanModel("2", "Program Keluarga Harapan", "Nabila Oktaviani", "Layak menerima bantuan"),
            PenerimaBantuanModel("3", "Bantuan Pangan Non Tunai", "Maida Olivia Kuswandari M.M.", "Layak menerima bantuan"),
            PenerimaBantuanModel("4", "Bantuan Untuk Orang Kurang Mampu", "Kartika Andriani S.IP", "Layak menerima bantuan"),
            PenerimaBantuanModel("5", "Bantuan Untuk Orang Kurang Mampu", "Rini Indah Safitri S.Pd", "Layak menerima bantuan"),
            PenerimaBantuanModel("6", "Bantuan Panti Asuhan", "Nasrullah Firmansyah S.Gz", "Layak menerima bantuan"),
            PenerimaBantuanModel("7", "Bantuan Langsung Tunai Desa", "Mila Paulin Anggraini M.Kom.", "Layak menerima bantuan")
        )

        val rv = view.findViewById<RecyclerView>(R.id.rvPenerimaTab)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = PenerimaBantuanAdapter(listData)
    }
}