package cl.desafiolatm.pruebacriptomoneda.modelo


import com.google.gson.annotations.SerializedName

data class Respuesta(
    @SerializedName("data")
    val data: List<Moneda>,
    @SerializedName("timestamp")
    val timestamp: Long
)