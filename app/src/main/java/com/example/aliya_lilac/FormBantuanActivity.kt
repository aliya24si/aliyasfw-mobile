package com.example.aliya_lilac

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class FormBantuanActivity : AppCompatActivity() {

    private var currentPhotoUri: Uri? = null
    private lateinit var ivBuktiFoto: ImageView

    private val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            currentPhotoUri?.let { uri ->
                ivBuktiFoto.setImageURI(uri)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_bantuan)

        val tvIdPenerima: TextView = findViewById(R.id.tvIdPenerima)
        val edtNamaPetugas: EditText = findViewById(R.id.edtNamaPetugas)
        val edtCatatanBantuan: EditText = findViewById(R.id.edtCatatanBantuan)
        ivBuktiFoto = findViewById(R.id.ivBuktiFoto)
        val btnAmbilFoto: MaterialButton = findViewById(R.id.btnAmbilFoto)
        val btnSubmitBantuan: MaterialButton = findViewById(R.id.btnSubmitBantuan)

        val idPenerima = intent.getStringExtra("EXTRA_ID_PENERIMA") ?: "Tidak Diketahui"
        tvIdPenerima.text = idPenerima

        btnAmbilFoto.setOnClickListener {
            val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            currentPhotoUri = createGalleryPhotoUri()
            intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, currentPhotoUri)
            cameraLauncher.launch(intentCamera)
        }

        btnSubmitBantuan.setOnClickListener {
            val petugas = edtNamaPetugas.text.toString().trim()
            val catatan = edtCatatanBantuan.text.toString().trim()

            if (petugas.isEmpty() || catatan.isEmpty() || currentPhotoUri == null) {
                Toast.makeText(this, "Harap lengkapi form dan foto bukti!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bantuan Sukses Disalurkan oleh $petugas!", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    private fun createGalleryPhotoUri(): Uri {
        val values = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "BUKTI_BANTUAN_${System.currentTimeMillis()}.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/BinaDesaBantuan")
        }
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            ?: throw RuntimeException("Gagal membuat URI Foto")
    }
}