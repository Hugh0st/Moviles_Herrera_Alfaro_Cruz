package com.hughost.practica_1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class CatHomeFragment : Fragment(R.layout.fragment_cat_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<Button>(R.id.btnGaleria).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.cat_fragment_container, CatGalleryFragment())
                .addToBackStack(null)
                .commit()
        }

        view.findViewById<Button>(R.id.btnCuriosidades).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.cat_fragment_container, CatFactsFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}