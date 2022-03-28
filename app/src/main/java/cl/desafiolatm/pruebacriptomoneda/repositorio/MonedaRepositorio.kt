package cl.desafiolatm.pruebacriptomoneda.repositorio

import android.content.Context
import androidx.lifecycle.LiveData
import cl.desafiolatm.pruebacriptomoneda.modelo.Moneda
import cl.desafiolatm.pruebacriptomoneda.room.ProyectoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MonedaRepositorio(var context: Context) {

    private val db = ProyectoDatabase.getDatabase(context)

    fun agregar(lista:List<Moneda>){
        CoroutineScope(Dispatchers.IO).launch {
            db.monedaDao().agregar(lista)
        }
    }

    fun listar(): LiveData<List<Moneda>> {
        return db.monedaDao().listar()
    }
}