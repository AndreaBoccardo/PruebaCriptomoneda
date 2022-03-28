package cl.desafiolatm.pruebacriptomoneda.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.desafiolatm.pruebacriptomoneda.dao.MonedaDao
import cl.desafiolatm.pruebacriptomoneda.modelo.Moneda
import cl.desafiolatm.pruebacriptomoneda.modelo.Respuesta
import cl.desafiolatm.pruebacriptomoneda.repositorio.MonedaRepositorio
import cl.desafiolatm.pruebacriptomoneda.repositorio.RespuestaRepositorio
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MonedaViewModel(application: Application): AndroidViewModel(application) {

    private val repo = RespuestaRepositorio()
    private val repoDao = MonedaRepositorio(application)
    var listaApi: MutableLiveData<List<Moneda>> = MutableLiveData()
    var listaRoom: LiveData<List<Moneda>> = repoDao.listar()
    var moneda = MutableLiveData<Moneda>()


    fun obtenerMoneda(){
        repo.getCall().enqueue(object : Callback<Respuesta>{
            override fun onResponse(call: Call<Respuesta>, response: Response<Respuesta>) {
                response.body().let {
                   // listaApi.postValue(response.body()?.data)
                    repoDao.agregar(response.body()!!.data)
                }
            }

            override fun onFailure(call: Call<Respuesta>, t: Throwable) {
                Log.d("CALL", t.message.toString())
            }

        })
    }



}