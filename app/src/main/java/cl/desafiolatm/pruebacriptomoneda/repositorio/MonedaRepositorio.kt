package cl.desafiolatm.pruebacriptomoneda.repositorio

import android.content.Context
import cl.desafiolatm.pruebacriptomoneda.room.ProyectoDatabase

class MonedaRepositorio(var context: Context) {

    private val db = ProyectoDatabase.getDatabase(context)
}