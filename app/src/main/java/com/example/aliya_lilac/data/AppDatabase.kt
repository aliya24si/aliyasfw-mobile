package com.example.aliya_lilac.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aliya_lilac.data.dao.PengaduanDao
import com.example.aliya_lilac.data.entity.PengaduanEntity

@Database(
    entities = [PengaduanEntity::class], // Mendaftarkan tabel pengaduan
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pengaduanDao(): PengaduanDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "bina_desa_database" // Nama file database SQLite nya
                )
                    .fallbackToDestructiveMigration() // Aman jika nanti ada perubahan kolom
                    .build().also { INSTANCE = it }
            }
        }
    }
}