package com.hughost.practica_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MichiAdapter(
    private val onItemClick: (Gatito) -> Unit
) : ListAdapter<Gatito, MichiAdapter.MichiViewHolder>(GatitoDiffCallback()) {

    // Crear ViewHolder ARA
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MichiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_michi, parent, false)
        return MichiViewHolder(view)
    }

    // Bind de datos ARA
    override fun onBindViewHolder(holder: MichiViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // ViewHolder ARA
    inner class MichiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imgMichi: ShapeableImageView = itemView.findViewById(R.id.img_michi)
        private val tvNombre: TextView = itemView.findViewById(R.id.tv_nombre_michi)

        fun bind(gatito: Gatito) {
            imgMichi.setImageResource(gatito.imagenRes)
            tvNombre.text = gatito.nombre
            itemView.setOnClickListener { onItemClick(gatito) }
        }
    }

    // Comparador DiffUtil ARA
    class GatitoDiffCallback : DiffUtil.ItemCallback<Gatito>() {

        override fun areItemsTheSame(oldItem: Gatito, newItem: Gatito): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Gatito, newItem: Gatito): Boolean =
            oldItem == newItem
    }
}
