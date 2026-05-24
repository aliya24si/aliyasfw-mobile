package com.example.aliya_lilac

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tilEmail = findViewById<TextInputLayout>(R.id.tilEmail)
        val tilPassword = findViewById<TextInputLayout>(R.id.tilPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegisterLink)

        val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Navigasi ke Register
        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val inputUser = tilEmail.editText?.text.toString().trim()
            val inputPass = tilPassword.editText?.text.toString().trim()

            // Reset error berkala
            tilEmail.error = null
            tilPassword.error = null

            // Ambil data registrasi dari Shared Preferences
            val registeredUser = sharedPref.getString("registered_user", "")
            val registeredPass = sharedPref.getString("registered_pass", "")

            if (inputUser.isEmpty()) {
                tilEmail.error = "Username/Email tidak boleh kosong"
                return@setOnClickListener
            }
            if (inputPass.isEmpty()) {
                tilPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            // Validasi aturan login
            if ((inputUser == inputPass) || (inputUser == registeredUser && inputPass == registeredPass)) {
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.apply()

                Toast.makeText(this, "Selamat Datang, $inputUser!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                tilEmail.error = "Username atau Password salah"
                tilPassword.error = "Username atau Password salah"
            }
        }
    }
}