package com.hughost.practica_1

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.imageview.ShapeableImageView

class MichiDetailFragment : Fragment() {

    // Clave del Bundle ARA
    companion object {
        private const val ARG_GATITO = "gatito"

        // Instancia con gatito serializado ARA
        fun newInstance(gatito: Gatito): MichiDetailFragment =
            MichiDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_GATITO, gatito)
                }
            }
    }

    // Inflate ARA
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_michi_detail, container, false)

    // Mostrar datos del gatito ARA
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gatito = getGatitoFromArgs() ?: return

        view.findViewById<ShapeableImageView>(R.id.img_detail_michi)
            .setImageResource(gatito.imagenRes)

        view.findViewById<TextView>(R.id.tv_detail_nombre).text = gatito.nombre
        view.findViewById<TextView>(R.id.tv_detail_descripcion).text = gatito.descripcion
    }

    // Recuperar gatito del Bundle compatible API 24+ ARA
    @Suppress("DEPRECATION")
    private fun getGatitoFromArgs(): Gatito? {
        val args = arguments ?: return null
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            args.getSerializable(ARG_GATITO, Gatito::class.java)
        } else {
            args.getSerializable(ARG_GATITO) as? Gatito
        }
    }
}
