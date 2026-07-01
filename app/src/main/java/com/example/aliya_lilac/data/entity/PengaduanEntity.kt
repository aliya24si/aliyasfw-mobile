package com.example.aliya_lilac.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pengaduan")
data class PengaduanEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val judul: String,
    val deskripsi: String,
    val tanggal: Long
)