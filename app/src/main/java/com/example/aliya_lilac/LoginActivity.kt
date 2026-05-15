package com.example.aliya_lilac

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegisterLink) // Tambahkan ID di XML login nanti
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Navigasi ke Register
        // Catatan: Pastikan di activity_login.xml, TextView "Register?" sudah diberi id: @+id/tvRegisterLink
        findViewById<TextView>(R.id.tvRegisterLink).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val inputUser = etEmail.text.toString()
            val inputPass = etPassword.text.toString()

            // Ambil data dari SP
            val registeredUser = sharedPref.getString("registered_user", "")
            val registeredPass = sharedPref.getString("registered_pass", "")

            // Rule 1: username = password
            // Rule 2: username & password sesuai yang diregistrasi
            if ((inputUser == inputPass && inputUser.isNotEmpty()) ||
                (inputUser == registeredUser && inputPass == registeredPass && inputUser.isNotEmpty())) {

                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.apply()

                Toast.makeText(this, "Selamat Datang, $inputUser!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                etEmail.error = "Username atau Password salah"
            }
        }
    }
}