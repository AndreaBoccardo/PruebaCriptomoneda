package cl.desafiolatm.pruebacriptomoneda.servicio

import cl.desafiolatm.pruebacriptomoneda.modelo.Respuesta
import retrofit2.Call
import retrofit2.http.GET

interface MonedaServicio {

    @GET("assets")
    fun getMoneda(): Call<Respuesta>
}