package com.hughost.practica_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondCircleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_circle)

        val btnCastigo = findViewById<Button>(R.id.btn_ver_castigo)
        btnCastigo.setOnClickListener {
            val intent = Intent(this, PunishmentActivity::class.java)
            startActivity(intent)
        }
    }
}