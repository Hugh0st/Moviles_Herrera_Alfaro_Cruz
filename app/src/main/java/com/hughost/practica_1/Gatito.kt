package com.hughost.practica_1

import java.io.Serializable

data class Gatito(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val imagenRes: Int
) : Serializable
