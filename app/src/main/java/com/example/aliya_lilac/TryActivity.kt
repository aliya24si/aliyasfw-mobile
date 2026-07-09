package com.example.aliya_lilac

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_try)

        val etNama = findViewById<EditText>(R.id.etNama)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {

            val nama = etNama.text.toString()

            Toast.makeText(
                this,
                "Halo $nama",
                Toast.LENGTH_SHORT
            ).show()

            Log.d("TryActivity", "Nama yang dimasukkan: $nama")
        }
    }
}