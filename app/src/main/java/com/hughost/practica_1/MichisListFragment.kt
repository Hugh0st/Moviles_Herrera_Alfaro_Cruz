package com.hughost.practica_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MichisListFragment : Fragment() {

    private lateinit var adapter: MichiAdapter

    // Inflate ARA
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_michis_list, container, false)

    // Configurar RecyclerView ARA
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MichiAdapter(onItemClick = ::navigateToDetail)

        view.findViewById<RecyclerView>(R.id.recycler_michis).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@MichisListFragment.adapter
            setHasFixedSize(true)
        }

        adapter.submitList(buildSampleList())
    }

    // Navegación al detalle con fade ARA
    private fun navigateToDetail(gatito: Gatito) {
        requireActivity().supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.fade_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.fade_out
            )
            .replace(R.id.fragment_container, MichiDetailFragment.newInstance(gatito))
            .addToBackStack("detail")
            .commit()
    }

    // Lista de gatitos de muestra ARA
    private fun buildSampleList(): List<Gatito> = listOf(
        Gatito(
            id = 1,
            nombre = "Luna",
            descripcion = "Una gatita muy traviesa y juguetona que ama esconderse en cajas de cartón. Su pasatiempo favorito es tirar cosas de la mesa y luego mirarte como si nada.",
            imagenRes = R.drawable.gatito_1
        ),
        Gatito(
            id = 2,
            nombre = "Mochi",
            descripcion = "Gato atigrado color naranja y extremadamente glotón. Su récord personal es dormir 18 horas seguidas sin moverse ni un solo centímetro.",
            imagenRes = R.drawable.gatito_2
        ),
        Gatito(
            id = 3,
            nombre = "Nube",
            descripcion = "Persa blanca esponjosísima. Tiene más pelo que personalidad, pero lo compensa con su mirada indiferente y su porte absolutamente majestuoso.",
            imagenRes = R.drawable.gatito_3
        ),
        Gatito(
            id = 4,
            nombre = "Canela",
            descripcion = "Siamés elegante y muy chismoso. Te mirará fijamente hasta que le des atención. Especialista certificada en maullar a las 3am sin razón aparente.",
            imagenRes = R.drawable.gatito_1
        ),
        Gatito(
            id = 5,
            nombre = "Oreo",
            descripcion = "Blanco y negro como su nombre. Experto en aparecer exactamente cuando abres la nevera o cualquier bolsa de plástico en un radio de 10 metros.",
            imagenRes = R.drawable.gatito_2
        )
    )
}
