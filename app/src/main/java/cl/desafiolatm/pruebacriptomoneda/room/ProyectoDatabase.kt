package cl.desafiolatm.pruebacriptomoneda.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.desafiolatm.pruebacriptomoneda.dao.MonedaDao
import cl.desafiolatm.pruebacriptomoneda.modelo.Moneda

@Database(entities = [Moneda::class], version = 1)
abstract class ProyectoDatabase: RoomDatabase() {

    abstract fun monedaDao(): MonedaDao

    companion object{
        @Volatile
        private var instancia:ProyectoDatabase? = null

        fun getDatabase(context: Context) : ProyectoDatabase
        {
            if(instancia == null)
            {
                synchronized(this)
                {
                    instancia = Room.databaseBuilder(context,ProyectoDatabase::class.java,"proyecto_db").build()
                }
            }
            return instancia!!
        }
    }
}