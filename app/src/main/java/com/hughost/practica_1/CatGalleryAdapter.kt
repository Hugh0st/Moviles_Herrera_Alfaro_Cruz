package com.hughost.practica_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CatGalleryAdapter(private val imageList: List<Int>) : RecyclerView.Adapter<CatGalleryAdapter.CatViewHolder>() {

    class CatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imgCat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat_image, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // Aquí le asignamos la imagen correspondiente a cada posición
        holder.imageView.setImageResource(imageList[position])
    }

    override fun getItemCount() = imageList.size
}