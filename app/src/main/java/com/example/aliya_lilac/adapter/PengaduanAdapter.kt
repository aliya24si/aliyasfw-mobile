package com.example.aliya_lilac.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aliya_lilac.R
import com.example.aliya_lilac.data.entity.PengaduanEntity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PengaduanAdapter(
    private val list: List<PengaduanEntity>
) : RecyclerView.Adapter<PengaduanAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val judul: TextView = itemView.findViewById(R.id.tvItemJudul)
        val tanggal: TextView = itemView.findViewById(R.id.tvItemTanggal)
        val deskripsi: TextView = itemView.findViewById(R.id.tvItemDeskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pengajuan, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.judul.text = item.judul
        holder.deskripsi.text = item.deskripsi

        val sdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        holder.tanggal.text = sdf.format(Date(item.tanggal))
    }
}