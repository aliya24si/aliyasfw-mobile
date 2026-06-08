package com.example.aliya_lilac

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                // Diarahkan ke OnboardingActivity terlebih dahulu sebelum login
                startActivity(Intent(this, OnboardingActivity::class.java))
            }
            finish()
        }, 2000)
    }
}