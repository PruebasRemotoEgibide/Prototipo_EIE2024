package com.example.huertaprototype.Modelo

import android.provider.ContactsContract.CommonDataKinds.Email

data class Usuario (

    var id: Int,
    var nombre: String,
    var apellidos: String,
    var username: String,
    var password: String,
    var email: String

)