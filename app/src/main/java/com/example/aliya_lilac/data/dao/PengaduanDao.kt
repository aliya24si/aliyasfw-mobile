package com.example.aliya_lilac.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aliya_lilac.data.entity.PengaduanEntity

@Dao
interface PengaduanDao {
    @Query("SELECT * FROM pengaduan ORDER BY tanggal DESC")
    suspend fun getAllPengaduan(): List<PengaduanEntity>

    @Insert
    suspend fun insertPengaduan(pengaduan: PengaduanEntity)
}