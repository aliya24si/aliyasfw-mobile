package com.example.aliya_lilac
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aliya_lilac.adapter.PengaduanAdapter
import com.example.aliya_lilac.data.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DaftarPengaduanActivity : AppCompatActivity() {
    private lateinit var rvPengaduan: RecyclerView
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_pengaduan)
        rvPengaduan = findViewById(R.id.rvPengaduan)
        rvPengaduan.layoutManager = LinearLayoutManager(this)
        db = AppDatabase.getInstance(this)
        loadData()

    }

    private fun loadData() {
        lifecycleScope.launch {
            val listPengaduan = withContext(Dispatchers.IO) {
                db.pengaduanDao().getAllPengaduan()
            }
            rvPengaduan.adapter = PengaduanAdapter(listPengaduan)
        }
    }

}