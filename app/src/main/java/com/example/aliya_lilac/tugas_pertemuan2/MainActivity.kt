package com.example.aliya_lilac.tugas_pertemuan2

import androidx.appcompat.app.AppCompatActivity
import com.example.aliya_lilac.R
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val alas = findViewById<EditText>(R.id.inputAlas)
        val tinggi = findViewById<EditText>(R.id.inputTinggi)
        val hitungSegitiga = findViewById<Button>(R.id.btnSegitiga)
        val hasilSegitiga = findViewById<TextView>(R.id.hasilSegitiga)

        val sisi = findViewById<EditText>(R.id.inputSisi)
        val hitungKubus = findViewById<Button>(R.id.btnKubus)
        val hasilKubus = findViewById<TextView>(R.id.hasilKubus)

        // Hitung luas segitiga
        hitungSegitiga.setOnClickListener {
            val a = alas.text.toString().toDoubleOrNull()
            val t = tinggi.text.toString().toDoubleOrNull()

            if (a != null && t != null) {
                val luas = 0.5 * a * t
                hasilSegitiga.text = "Luas Segitiga: $luas"
                Log.d("HITUNG", "Segitiga berhasil dihitung")
            } else {
                hasilSegitiga.text = "Input tidak valid"
            }
        }

        // Hitung volume kubus
        hitungKubus.setOnClickListener {
            val s = sisi.text.toString().toDoubleOrNull()

            if (s != null) {
                val volume = s * s * s
                hasilKubus.text = "Volume Kubus: $volume"
                Log.d("HITUNG", "Kubus berhasil dihitung")
            } else {
                hasilKubus.text = "Input tidak valid"
            }
        }
    }
}
