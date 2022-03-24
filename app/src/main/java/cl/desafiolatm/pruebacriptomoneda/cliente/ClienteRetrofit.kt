package cl.desafiolatm.pruebacriptomoneda.cliente

import cl.desafiolatm.pruebacriptomoneda.servicio.MonedaServicio
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClienteRetrofit {

    companion object{

        const val BASE_URL = "https://api.coincap.io/v2/"
        var cliente : Retrofit? = null

        fun getInstancia(): MonedaServicio {

            if(cliente == null){
                cliente = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return cliente!!.create(MonedaServicio::class.java)

        }
    }
}