package com.example.aliya_lilac

// Model untuk Data Program Bantuan
data class ProgramBantuanModel(
    val kode: String,
    val namaProgram: String,
    val tahun: String,
    val anggaran: String,
    val imageUrl: String // Tambahan untuk foto program
)

// Model untuk Data Penerima Bantuan
data class PenerimaBantuanModel(
    val nomor: String,
    val program: String,
    val warga: String,
    val keterangan: String,
    val imageUrl: String // Tambahan untuk foto warga/penerima
)