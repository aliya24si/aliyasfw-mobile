package com.example.aliya_lilac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val viewPager = findViewById<ViewPager2>(R.id.onboardingViewPager)
        val dotIndicator = findViewById<DotsIndicator>(R.id.dotIndicator)

        val fragmentsList = listOf(
            OnboardingStepFragment.newInstance("Selamat Datang", "Aplikasi Bina Desa membantu mempermudah penyaluran bantuan sosial bagi masyarakat.", R.drawable.logo_apps, false),
            OnboardingStepFragment.newInstance("Pantau Program", "Lihat daftar program bantuan desa aktif langsung dari genggaman Anda.", R.drawable.logo_apps, false),
            OnboardingStepFragment.newInstance("Transparansi Data", "Cek validitas data penerima bantuan sosial secara real-time dan transparan.", R.drawable.logo_apps, true)
        )

        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragmentsList.size
            override fun createFragment(position: Int): Fragment = fragmentsList[position]
        }

        viewPager.adapter = adapter
        dotIndicator.attachTo(viewPager)
    }
}