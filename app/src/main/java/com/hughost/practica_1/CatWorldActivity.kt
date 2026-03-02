package com.hughost.practica_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CatWorldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_world)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.cat_fragment_container, CatHomeFragment())
                .commit()
        }
    }
}