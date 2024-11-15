package com.example.huertaprototype.BBDD

import androidx.lifecycle.MutableLiveData
import com.example.huertaprototype.Modelo.Planta
import java.util.Calendar
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser
import com.parse.PointerEncoder

class BBDDParse {

    fun mostrarPlantas(): MutableLiveData<List<Planta>> {
        val currentPlants: MutableLiveData<List<Planta>> = MutableLiveData()
        val query = ParseQuery.getQuery<ParseObject>("Plants")
        query.findInBackground { objects, e ->
            if (e == null) {
                val plants = objects.map { parseObj ->
                    val harvestDate = Calendar.getInstance()
                    harvestDate.timeInMillis = parseObj.getLong("cosecha") ?: 0
                    Planta(
                        parseObj.getInt("id") ?: 0,
                        parseObj.getString("nombre") ?: "",
                        parseObj.getInt("riego") ?: 0,
                        harvestDate
                    )
                }
                currentPlants.postValue(plants)
            }
        }
        return currentPlants
    }

    fun insertarPlanta(planta: Planta) {
        val plantObject = ParseObject("Plants")
        plantObject.put("nombre", planta.nombre)
        plantObject.put("riego", planta.riego)
        plantObject.put("cosecha", planta.cosecha.timeInMillis)
        plantObject.saveInBackground { e ->
            if (e != null) {
                e.localizedMessage?.let { throw Exception(e.localizedMessage) }
            }
        }
    }

    fun borrarPlanta(planta: Planta) {
        val query = ParseQuery.getQuery<ParseObject>("Planta")
        query.whereEqualTo("index", planta.id)
        query.getFirstInBackground { parseObject, parseException ->
            if (parseException == null) {
                parseObject.deleteInBackground { deleteException ->
                    if (deleteException != null) {
                        throw Exception(deleteException.localizedMessage)
                    }
                }
            } else {
                throw Exception(parseException.localizedMessage)
            }
        }
    }

    fun modificarPlanta(planta: Planta) {
        val query = ParseQuery.getQuery<ParseObject>("Planta")
        query.whereEqualTo("index", planta.id)
        query.getFirstInBackground { parseObject, parseException ->
            if (parseException == null) {
                parseObject.put("riego", planta.riego)
                parseObject.put("cosecha", planta.cosecha.timeInMillis)
                parseObject.saveInBackground { saveException ->
                    if (saveException != null) {
                        throw Exception(saveException.localizedMessage)
                    }
                }
            } else {
                throw Exception(parseException.localizedMessage)
            }
        }
    }


    fun getKey(username: String, password: String): MutableLiveData<String> {
        val current = MutableLiveData<String>()
        val query = ParseQuery.getQuery<ParseObject>("Usuarios")
        query.whereEqualTo("User", username)
        query.getFirstInBackground { i, parseException ->
            if (parseException == null) {
                if (i.getString("Password").equals(password)) {
                    current.postValue(i.getString("objectId"))
                } else current.postValue("")
            } else {
                print(parseException)
                throw Exception(parseException)
            }
        }
        return current
    }


}