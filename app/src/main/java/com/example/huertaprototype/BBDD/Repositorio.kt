package com.example.huertaprototype.BBDD

import androidx.lifecycle.MutableLiveData
import com.example.huertaprototype.Modelo.Parte
import com.example.huertaprototype.Modelo.Planta
import com.example.huertaprototype.Modelo.PreguntasFrecuentes
import com.example.huertaprototype.Modelo.Usuario

class Repositorio(val parser: BBDDParse) {

    /*
    // region Sobre Parte
    fun mostrarPartes() = MutableLiveData<List<Parte>> {
        return parser.mostrarPartes()
    }

    fun insertarParte(current: Parte) {
        parser.insertarParte(current)
    }

    fun borrarParte(current: Parte) {
        parser.borrarParte(current)
    }

    fun modificarEvento(current: Parte) {
        parser.modificarEvento(current);
    }

    fun idMaximo() = MutableLiveData<Int> {
        return parser.buscarIdMaximo()
    }

    fun parteById(index: Int) = MutableLiveData<Parte> {
         return parser.parteById(index)
    }

    // endregion

    // region Sobre Usuario
    fun mostrarUsuarios() = MutableLiveData<List<Usuario>> {
         return= parser.mostrarUsuarios()
    }
    fun getKey(user:String, password:String):MutableLiveData<String>{
        return parser.getKey(user,password)
    }
    // endregion

    // region Sobre PreguntasFrecuentes

    fun mostrarPreguntasFrecuentes() = MutableLiveData<List<PreguntasFrecuentes>> {
        return parser.mostrarPreguntasFrecuentes()
    }
    // endregion

*/
    // region Sobre Planta
    fun mostrarPlantas() = MutableLiveData<List<Planta>> {
        return parser.mostrarPlantas()
    }

    fun insertarPlanta(current: Planta) {
        parser.insertarPlanta(current)
    }

    fun borrarPlanta(current: Planta) {
        parser.borrarPlanta(current)
    }

    fun modificarPlanta(current: Planta) {
        parser.modificarPlanta(current);
    }

    // endregion


}