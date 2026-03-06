package com.hughost.practica_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.RecyclerView

// Usamos el constructor del Fragment para inflar el layout directamente
class CatGalleryFragment : Fragment(R.layout.fragment_cat_gallery) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewGallery)

        // Lista con las referencias a tus 8 imágenes
        val catImages = listOf(
            R.drawable.gatito_1,
            R.drawable.gatito_2,
            R.drawable.gatito_3,
            R.drawable.gatito_4,
            R.drawable.gatito_5,
            R.drawable.gatito_6,
            R.drawable.gatito_7,
            R.drawable.gatito_8
        )

        // Conectamos el RecyclerView con el adaptador
        recyclerView.adapter = CatGalleryAdapter(catImages)
    }
}