package com.example.aliya_lilac

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

data class NewsResponse(
    val status: String?,
    val code: String?,
    val message: String?,
    val totalResults: Int?,
    val articles: List<NewsModel>?
)

data class NewsModel(
    val title: String,
    val description: String?,
    val urlToImage: String?
)

interface NewsApiService {
    @GET("v2/everything?q=indonesia&apiKey=c770505117664ffbaed2cc3bb49ae263")
    suspend fun getBansosNews(): NewsResponse
}

object NewsApiClient {

    private const val BASE_URL = "https://newsapi.org/"

    val apiService: NewsApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }
}