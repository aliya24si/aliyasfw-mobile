package com.example.aliya_lilac

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val newsList: List<NewsModel>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvNewsTitle)
        val desc: TextView = view.findViewById(R.id.tvNewsDesc)
        val image: ImageView = view.findViewById(R.id.ivNewsImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.title.text = news.title
        holder.desc.text = news.description ?: "Tidak ada deskripsi."

        Glide.with(holder.itemView.context)
            .load(news.urlToImage)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(holder.image)
    }

    override fun getItemCount(): Int = newsList.size
}