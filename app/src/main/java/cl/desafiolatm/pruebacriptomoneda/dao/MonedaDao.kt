package cl.desafiolatm.pruebacriptomoneda.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import cl.desafiolatm.pruebacriptomoneda.modelo.Moneda
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface MonedaDao {

    @Insert(onConflict = REPLACE)
    suspend fun agregar(lista:List<Moneda>)

    @Query("select imagen from moneda_table where simbolo = :simbolo")
    fun agregarImagen(simbolo:String)

    @Query("select cambio, web, id, capital_mercado, suministro_maximo, nombre, valor, ranking, suministro, simbolo, volumen, vwap, imagen from moneda_table ")
    fun listar(): LiveData<List<Moneda>>
}