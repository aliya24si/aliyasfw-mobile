package com.example.aliya_lilac

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        holder.binding.tvRowKode.text = data.kode
        holder.binding.tvRowNamaProgram.text = data.namaProgram
        holder.binding.tvRowTahun.text = "Tahun: ${data.tahun}"
        holder.binding.tvRowAnggaran.text = "Anggaran: ${data.anggaran}"
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
        holder.binding.tvRowWarga.text = data.warga
        holder.binding.tvRowProgramPenerima.text = "Program: ${data.program}"
        holder.binding.tvRowKeterangan.text = data.keterangan
    }

    override fun getItemCount(): Int = list.size
}