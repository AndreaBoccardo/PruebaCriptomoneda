package cl.desafiolatm.pruebacriptomoneda.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatm.pruebacriptomoneda.R
import cl.desafiolatm.pruebacriptomoneda.R.*
import cl.desafiolatm.pruebacriptomoneda.databinding.ItemLayoutBinding
import cl.desafiolatm.pruebacriptomoneda.modelo.Moneda
import com.squareup.picasso.Picasso

class MonedaAdaptador: RecyclerView.Adapter<MonedaAdaptador.CustomViewHolder>() {

    var lista:List<Moneda> = ArrayList()
    lateinit var listener: miListener

    class CustomViewHolder(itemView: View, var listener: miListener): RecyclerView.ViewHolder(itemView){

        private val binding = ItemLayoutBinding.bind(itemView)


        fun bindData(moneda: Moneda){
            with(binding){
                tvSimboloLista.text = moneda.symbol
                tvValorLista.text = moneda.priceUsd
                Picasso.get().load("https://static.coincap.io/assets/icons/${moneda.symbol?.lowercase()}@2x.png"
                ).into(ivImagenLista)
                itemView.setOnClickListener {
                    listener.miOnClick(moneda)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout.item_layout,parent,false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun updateLista(lista:List<Moneda>){
        this.lista = lista
        notifyDataSetChanged()
    }

    interface miListener{
        fun miOnClick(moneda: Moneda)
    }

    fun updateListener(listener: miListener)
    {
        this.listener = listener
    }

    fun filtrarLista(lista:List<Moneda>){
        this.lista = lista
        notifyDataSetChanged()
    }

}