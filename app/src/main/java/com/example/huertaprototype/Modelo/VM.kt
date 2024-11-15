package com.example.huertaprototype.Modelo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.huertaprototype.BBDD.Repositorio
import kotlinx.coroutines.launch

class VM(private val repositorio: Repositorio) : ViewModel() {
    lateinit var partes: MutableLiveData<List<Parte>>
    lateinit var numMax: MutableLiveData<Int>
    lateinit var usuarios: MutableLiveData<List<Usuario>>
    lateinit var currentParte: MutableLiveData<Parte>
    lateinit var preguntasFrecuentes: MutableLiveData<List<PreguntasFrecuentes>>
    lateinit var plantas: MutableLiveData<List<Planta>>

    // region Sobre Parte
    fun mostrarPartes() = viewModelScope.launch {
        partes = repositorio.mostrarPartes()
    }

    fun insertParte(current: Parte) {
        repositorio.insertarParte(current)
    }

    fun deleteParte(current: Parte) {
        repositorio.borrarParte(current)
    }

    fun updateParte(current: Parte) {
        repositorio.modificarEvento(current);
    }

    fun idMax() = viewModelScope.launch {
        numMax = repositorio.idMaximo()
    }

    fun searchParte(index: Int) = viewModelScope.launch {
        currentParte = repositorio.eventById(index)
    }

    // endregion

    // region Sobre Usuario
    fun showUsers() = viewModelScope.launch {
        usuarios = repositorio.mostrarUsuarios()
    }
    // endregion

    // region Sobre PreguntasFrecuentes

    fun mostrarPreguntasFrecuentes() = viewModelScope.launch {
        preguntasFrecuentes = repositorio.mostrarPreguntasFrecuentes()
    }
    // endregion


    // region Sobre Planta
    fun mostrarPlantas() = viewModelScope.launch {
        plantas = repositorio.mostrarPlantas()
    }
    fun insertPlanta(current: Planta) {
        repositorio.insertarPlanta(current)
    }

    fun deletePlanta(current: Planta) {
        repositorio.borrarPlanta(current)
    }

    fun updatePlanta(current: Planta) {
        repositorio.modificarPlanta(current);
    }

    // endregion


}

class ParteViewModelFactory(private val miRepositorio: Repositorio) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return VM(miRepositorio) as T
        }
        throw IllegalArgumentException("ViewModel class desconocida")
    }
}