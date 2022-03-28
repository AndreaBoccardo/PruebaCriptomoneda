package cl.desafiolatm.pruebacriptomoneda.room

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import cl.desafiolatm.pruebacriptomoneda.dao.MonedaDao
import cl.desafiolatm.pruebacriptomoneda.getOrAwaitValue
import cl.desafiolatm.pruebacriptomoneda.modelo.Moneda
import com.google.common.truth.Truth
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProyectoDatabaseTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var db: ProyectoDatabase
    private lateinit var dao: MonedaDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,ProyectoDatabase::class.java).allowMainThreadQueries().build()
        dao = db.monedaDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun test_listar(){
        var moneda = Moneda("22", "www.ima.com", "aaa", "24"
            , "2.2", "crip", "21", "2", "0,5", "cr"
            , "2,2", "0,6")
        var lista = listOf<Moneda>(moneda)
        moneda.id2 = 1
        dao.agregar(lista)
        val list = dao.listar().getOrAwaitValue()
        Truth.assertThat(list[0].id2).isEqualTo(moneda.id2)

    }
}