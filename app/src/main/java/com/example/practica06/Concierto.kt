package com.example.practica06

import java.io.Serializable

data class Concierto(
    var codigo: Int,
    var artista: String,
    var lugar: String,
    var fecha: String,
    var servicio: Int,
    var zona: String
) : Serializable
