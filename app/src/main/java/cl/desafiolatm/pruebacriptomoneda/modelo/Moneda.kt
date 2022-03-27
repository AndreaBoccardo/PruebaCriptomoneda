package cl.desafiolatm.pruebacriptomoneda.modelo


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "moneda_table")
data class Moneda(
    @SerializedName("changePercent24Hr")
    @ColumnInfo(name = "cambio") val changePercent24Hr: String?,
    @SerializedName("explorer")
    @ColumnInfo(name = "web") val explorer: String?,
    @SerializedName("id")
    @ColumnInfo(name = "id") val id: String?,
    @SerializedName("marketCapUsd")
    @ColumnInfo(name = "capital_mercado") val marketCapUsd: String?,
    @SerializedName("maxSupply")
    @ColumnInfo(name = "suministro_maximo") val maxSupply: String?,
    @SerializedName("name")
    @ColumnInfo(name = "nombre") val name: String?,
    @SerializedName("priceUsd")
    @ColumnInfo(name = "valor") val priceUsd: String?,
    @SerializedName("rank")
    @ColumnInfo(name = "ranking") val rank: String?,
    @SerializedName("supply")
    @ColumnInfo(name = "suministro") val supply: String?,
    @SerializedName("symbol")
    @ColumnInfo(name = "simbolo") val symbol: String?,
    @SerializedName("volumeUsd24Hr")
    @ColumnInfo(name = "volumen") val volumeUsd24Hr: String?,
    @SerializedName("vwap24Hr")
    @ColumnInfo(name = "vwap") val vwap24Hr: String?,
    @ColumnInfo(name = "imagen")
    val imagen: String?
){
    @PrimaryKey(autoGenerate = true)
    var id2: Int  = 0
}