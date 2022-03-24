package cl.desafiolatm.pruebacriptomoneda.repositorio

import cl.desafiolatm.pruebacriptomoneda.cliente.ClienteRetrofit
import cl.desafiolatm.pruebacriptomoneda.modelo.Respuesta
import retrofit2.Call

class RespuestaRepositorio {

    private val cliente = ClienteRetrofit.getInstancia()

    fun getCall(): Call<Respuesta> {
        return cliente.getMoneda()
    }
}