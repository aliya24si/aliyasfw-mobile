package com.example.aliya_lilac

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class BeritaFragment : Fragment(R.layout.fragment_berita) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(
            requireContext(),
            "BeritaFragment terbuka",
            Toast.LENGTH_SHORT
        ).show()

        val rvNews = view.findViewById<RecyclerView>(R.id.rvNewsBansos)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBarNews)

        rvNews.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            progressBar.visibility = View.VISIBLE

            try {

                val response = NewsApiClient.apiService.getBansosNews()

                Toast.makeText(
                    requireContext(),
                    """
        Status: ${response.status}
        Code: ${response.code}
        Total: ${response.totalResults}
        Message: ${response.message}
        """.trimIndent(),
                    Toast.LENGTH_LONG
                ).show()

                if (!response.articles.isNullOrEmpty()) {
                    rvNews.adapter = NewsAdapter(response.articles)
                }

            } catch (e: Exception) {

                Toast.makeText(
                    requireContext(),
                    "ERROR: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()

                Log.e("NEWS_ERROR", "ERROR", e)
            } finally {
                progressBar.visibility = View.GONE
            }
        }
    }
}