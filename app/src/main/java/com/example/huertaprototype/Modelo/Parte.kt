package com.example.huertaprototype.Modelo

import java.util.Date
import java.util.Calendar

data class Parte(
    var id: Int,
    var fecha: Calendar,
    var cantidad: Int,
    var cosecha: Calendar,
    var usuario: Int,
    var planta: Int
)