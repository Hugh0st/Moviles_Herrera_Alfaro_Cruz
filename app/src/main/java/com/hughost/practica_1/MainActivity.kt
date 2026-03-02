package com.hughost.practica_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNav.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_gatitos      -> MichisListFragment()
                R.id.nav_curiosidades -> CuriosidadesFragment()
                else -> return@setOnItemSelectedListener false
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            true
        }

        // Mostrar la lista de gatitos como pantalla inicial (solo en el primer arranque)
        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.nav_gatitos
        }
    }
}
