package cl.desafiolatm.pruebacriptomoneda.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.desafiolatm.pruebacriptomoneda.R
import cl.desafiolatm.pruebacriptomoneda.databinding.FragmentDetalleBinding
import cl.desafiolatm.pruebacriptomoneda.viewmodel.MonedaViewModel
import com.squareup.picasso.Picasso

class DetalleFragment : Fragment() {

    private lateinit var binding: FragmentDetalleBinding
    private val viewModel by activityViewModels<MonedaViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater)

        viewModel.moneda.observe(viewLifecycleOwner, Observer {moneda->
            with(binding){
               Picasso.get().load("https://static.coincap.io/assets/icons/${moneda.symbol?.lowercase()}@2x.png"
               ).into(ivDetalle)
                tvNombreDetalle.text = moneda.name
                etRanking.text = moneda.rank
                etPrecio.text = moneda.priceUsd
                etSuministro.text = moneda.supply
                etmaxSuministro.text = moneda.maxSupply
                etCapitalMercado.text = moneda.marketCapUsd
                etVolumen.text = moneda.volumeUsd24Hr
                etCambio.text = moneda.changePercent24Hr
                etVWAP.text = moneda.vwap24Hr
            }

        })


        return binding.root
    }
}