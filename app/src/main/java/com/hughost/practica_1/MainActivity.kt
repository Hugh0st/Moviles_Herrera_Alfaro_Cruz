package com.hughost.practica_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNav.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_catworld -> {
                    val intent = Intent(this, CatWorldActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_inicio -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, InicioFragment())
                        .commit()
                    true
                }

                R.id.nav_gatitos -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MichisListFragment())
                        .commit()
                    true
                }

                R.id.nav_curiosidades -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, CuriosidadesFragment())
                        .commit()
                    true
                }

                else -> false
            }
        }

        // 4️⃣ Mostrar el fragment Inicio al abrir la app (solo primera vez)
        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.nav_inicio
        }
    }
}