package com.example.aliya_lilac

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etTanggalLahir = findViewById<EditText>(R.id.etTanggalLahir)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val spAgama = findViewById<Spinner>(R.id.spAgama)
        val etUsername = findViewById<EditText>(R.id.etRegUsername)
        val etPassword = findViewById<EditText>(R.id.etRegPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitRegister)

        // Setup Spinner Agama
        val daftarAgama = arrayOf("Pilih Agama", "Islam", "Kristen", "Katolik", "Hindu", "Budha", "Khonghucu")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, daftarAgama)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spAgama.adapter = adapter

        // Fitur DatePicker
        etTanggalLahir.setOnClickListener {
            val c = Calendar.getInstance()
            DatePickerDialog(this, { _, year, month, day ->
                etTanggalLahir.setText("$day/${month + 1}/$year")
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()
        }

        btnSubmit.setOnClickListener {
            val nama = etNama.text.toString()
            val tgl = etTanggalLahir.text.toString()
            val username = etUsername.text.toString()
            val pass = etPassword.text.toString()
            val confirm = etConfirmPassword.text.toString()
            val selectedGenderId = rgGender.checkedRadioButtonId
            val agama = spAgama.selectedItem.toString()

            var isValid = true

            // Validasi (Menggunakan setError untuk menunjukkan isian yang salah)
            if (nama.isEmpty()) { etNama.error = "Nama wajib diisi"; isValid = false }
            if (tgl.isEmpty()) { etTanggalLahir.error = "Pilih tanggal lahir"; isValid = false }
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Pilih Jenis Kelamin", Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (agama == "Pilih Agama") {
                Toast.makeText(this, "Pilih Agama", Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (username.isEmpty()) { etUsername.error = "Username wajib diisi"; isValid = false }
            if (pass.isEmpty()) { etPassword.error = "Password wajib diisi"; isValid = false }
            if (pass != confirm) {
                etConfirmPassword.error = "Password tidak cocok"; isValid = false
            }

            if (isValid) {
                // Simpan ke Shared Preferences
                val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("registered_name", nama)
                editor.putString("registered_user", username)
                editor.putString("registered_pass", pass)
                editor.apply()

                Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
                finish() // Kembali ke Login
            }
        }
    }
}