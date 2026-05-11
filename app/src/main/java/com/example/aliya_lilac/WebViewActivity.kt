package com.example.aliya_lilac

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        // Setup Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbarWeb)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Desktop View Bina Desa"
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Tombol Back

        val webView = findViewById<WebView>(R.id.webViewBinaDesa)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://aliya.alwaysdata.net")
    }

    // Fungsi tombol back di toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}