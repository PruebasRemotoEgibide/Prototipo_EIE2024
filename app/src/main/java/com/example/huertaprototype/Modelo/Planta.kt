package com.example.huertaprototype.Modelo

import java.util.Calendar

data class Planta(
    var id: Int,
    var nombre: String,
    var riego: Int,
    var cosecha: Calendar
)

