package com.example.aliya_lilac

// Model untuk Data Program Bantuan (Foto 2)
data class ProgramBantuanModel(
    val kode: String,
    val namaProgram: String,
    val tahun: String,
    val anggaran: String
)

// Model untuk Data Penerima Bantuan (Foto 1)
data class PenerimaBantuanModel(
    val nomor: String,
    val program: String,
    val warga: String,
    val keterangan: String
)