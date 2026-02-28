package com.hughost.practica_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class UpperHellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upper_hell)

        val btnDescender = findViewById<Button>(R.id.btn_descender_segundo)
        btnDescender.setOnClickListener {
            val intent = Intent(this, SecondCircleActivity::class.java)
            startActivity(intent)
        }
    }
}