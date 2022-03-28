package cl.desafiolatm.pruebacriptomoneda.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatm.pruebacriptomoneda.R
import cl.desafiolatm.pruebacriptomoneda.adaptador.MonedaAdaptador
import cl.desafiolatm.pruebacriptomoneda.databinding.FragmentListaBinding
import cl.desafiolatm.pruebacriptomoneda.modelo.Moneda
import cl.desafiolatm.pruebacriptomoneda.viewmodel.MonedaViewModel

class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    lateinit var archivo: SharedPreferences
    private val ARCHIVO_NAME = "mi_preferencia"
    private val viewModel by activityViewModels<MonedaViewModel>()
    private val adapter = MonedaAdaptador()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater)

        archivo = requireActivity().getSharedPreferences(ARCHIVO_NAME, Context.MODE_PRIVATE)

        with(binding){
            tvNombreUsuario.text = archivo.getString("name","NO_NAME")
        }

        adapter.updateListener(object : MonedaAdaptador.miListener{
            override fun miOnClick(moneda: Moneda) {
                viewModel.obtenerMoneda()
                Navigation.findNavController(requireView()).navigate(R.id.action_listaFragment_to_detalleFragment)
            }
        })

        with(binding){
            val manager = LinearLayoutManager(requireContext())
            rvLista.adapter = adapter
            rvLista.layoutManager = manager
        }

        viewModel.listaApi.observe(viewLifecycleOwner, Observer {
            adapter.updateLista(it)
        })

        viewModel.listaRoom.observe(viewLifecycleOwner, Observer {
            adapter.updateLista(it)
        })



        return binding.root
    }
}