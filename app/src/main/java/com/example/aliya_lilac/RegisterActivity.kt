package com.example.aliya_lilac

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Binding kontainer TextInputLayout untuk kontrol penulisan error
        val tilNama = findViewById<TextInputLayout>(R.id.tilNama)
        val tilTanggalLahir = findViewById<TextInputLayout>(R.id.tilTanggalLahir)
        val tilRegUsername = findViewById<TextInputLayout>(R.id.tilRegUsername)
        val tilRegPassword = findViewById<TextInputLayout>(R.id.tilRegPassword)
        val tilConfirmPassword = findViewById<TextInputLayout>(R.id.tilConfirmPassword)

        // Binding komponen input bawaan interior
        val etTanggalLahir = tilTanggalLahir.editText
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val spAgama = findViewById<Spinner>(R.id.spAgama)
        val btnSubmit = findViewById<MaterialButton>(R.id.btnSubmitRegister)

        // Setup Spinner Agama
        val daftarAgama = arrayOf(
            "Pilih Agama",
            "Islam",
            "Kristen",
            "Katolik",
            "Hindu",
            "Budha",
            "Khonghucu"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, daftarAgama)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spAgama.adapter = adapter

        // Fitur DatePicker terpasang langsung pada EditText di dalam TextInputLayout
        etTanggalLahir?.setOnClickListener {
            val c = Calendar.getInstance()
            DatePickerDialog(
                this,
                { _, year, month, day ->
                    etTanggalLahir.setText("$day/${month + 1}/$year")
                },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        btnSubmit.setOnClickListener {
            val nama = tilNama.editText?.text.toString().trim()
            val tgl = tilTanggalLahir.editText?.text.toString().trim()
            val username = tilRegUsername.editText?.text.toString().trim()
            val pass = tilRegPassword.editText?.text.toString().trim()
            val confirm = tilConfirmPassword.editText?.text.toString().trim()
            val selectedGenderId = rgGender.checkedRadioButtonId
            val agama = spAgama.selectedItem.toString()

            // Reset status error di awal klik submit
            tilNama.error = null
            tilTanggalLahir.error = null
            tilRegUsername.error = null
            tilRegPassword.error = null
            tilConfirmPassword.error = null

            var isValid = true

            // Validasi Input Menggunakan TextInputLayout error style
            if (nama.isEmpty()) {
                tilNama.error = "Nama wajib diisi"
                isValid = false
            }
            if (tgl.isEmpty()) {
                tilTanggalLahir.error = "Pilih tanggal lahir"
                isValid = false
            }
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Pilih Jenis Kelamin", Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (agama == "Pilih Agama") {
                Toast.makeText(this, "Pilih Agama", Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (username.isEmpty()) {
                tilRegUsername.error = "Username wajib diisi"
                isValid = false
            }
            if (pass.isEmpty()) {
                tilRegPassword.error = "Password wajib diisi"
                isValid = false
            }
            if (pass != confirm && pass.isNotEmpty()) {
                tilConfirmPassword.error = "Password tidak cocok"
                isValid = false
            }

            if (isValid) {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Konfirmasi Registrasi")
                    .setMessage("Apakah data yang Anda masukkan sudah benar?")
                    .setPositiveButton("Ya") { _, _ ->

                        // Simpan ke Shared Preferences
                        val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                        val editor = sharedPref.edit()
                        editor.putString("registered_name", nama)
                        editor.putString("registered_user", username)
                        editor.putString("registered_pass", pass)
                        editor.apply()

                        Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
                        finish() // Menutup activity dan otomatis kembali ke Login
                    }
                    .setNegativeButton("Batal", null)
                    .show()
            }
        }
    }
}