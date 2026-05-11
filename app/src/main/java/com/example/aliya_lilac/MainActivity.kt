package com.example.aliya_lilac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Dashboard Bina Desa"

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Tampilkan HomeFragment pertama kali
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment(), "Home")
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment(), "Dashboard Bina Desa")
                R.id.nav_about -> replaceFragment(AboutFragment(), "Tentang Bina Desa")
                R.id.nav_profile -> replaceFragment(ProfileFragment(), "Profil Pengembang")
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        supportActionBar?.title = title
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}