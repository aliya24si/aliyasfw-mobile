package com.example.aliya_lilac

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnWebView: Button = view.findViewById(R.id.btnWebView)
        val btnLogout: Button = view.findViewById(R.id.btnLogout)

        val tabLayout: TabLayout = view.findViewById(R.id.home_tab_layout)
        val viewPager: ViewPager2 = view.findViewById(R.id.home_view_pager)

        btnWebView.setOnClickListener {
            val intent = Intent(requireContext(), WebViewActivity::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            sharedPref.edit().clear().apply()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }

        // --- Inisialisasi Sistem Tab Konten Bina Desa ---
        val pagerAdapter = HomePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Program Bantuan"
                1 -> tab.text = "Penerima Bantuan"
            }
        }.attach()
    }
}