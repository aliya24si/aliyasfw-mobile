package com.example.aliya_lilac

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    // Diubah jumlah itemnya menjadi 3 buah tab
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabProgramFragment()
            1 -> TabPenerimaFragment()
            else -> BeritaFragment() // Tab indeks ke-2 diarahkan ke BeritaFragment
        }
    }
}