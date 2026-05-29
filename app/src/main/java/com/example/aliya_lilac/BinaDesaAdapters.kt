package com.example.aliya_lilac

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aliya_lilac.databinding.ItemRowPenerimaBinding
import com.example.aliya_lilac.databinding.ItemRowProgramBinding

class ProgramBantuanAdapter(private val list: List<ProgramBantuanModel>) :
    RecyclerView.Adapter<ProgramBantuanAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemRowProgramBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRowProgramBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]

        // Panggilan untuk item_row_program.xml
        holder.binding.tvRowKode.text = data.kode
        holder.binding.tvRowNamaProgram.text = data.namaProgram
        holder.binding.tvRowTahun.text = "Tahun: ${data.tahun}"
        holder.binding.tvRowAnggaran.text = "Anggaran: ${data.anggaran}"

        Glide.with(holder.itemView.context)
            .load(data.imageUrl)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(holder.binding.imgRowProgram)
    }

    override fun getItemCount(): Int = list.size
}

class PenerimaBantuanAdapter(private val list: List<PenerimaBantuanModel>) :
    RecyclerView.Adapter<PenerimaBantuanAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemRowPenerimaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRowPenerimaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]

        // Panggilan untuk item_row_penerima.xml (Sudah sinkron!)
        holder.binding.tvRowWarga.text = data.warga
        holder.binding.tvRowProgramPenerima.text = "Program: ${data.program}"
        holder.binding.tvRowKeterangan.text = data.keterangan

        Glide.with(holder.itemView.context)
            .load(data.imageUrl)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(holder.binding.imgRowPenerima)
    }

    override fun getItemCount(): Int = list.size
}