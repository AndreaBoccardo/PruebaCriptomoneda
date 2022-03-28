package cl.desafiolatm.pruebacriptomoneda.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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

        setHasOptionsMenu(true)

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

        viewModel.listaRoom.observe(viewLifecycleOwner, Observer {
            adapter.updateLista(it)
        })

        viewModel.filtro.observe(viewLifecycleOwner, Observer {
            adapter.filtrarLista(viewModel.listaRoom.value!!.filter {
                m -> m.name!!.contains(it.uppercase()) || m.symbol!!.contains(it.uppercase())
            })
        })



        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }
}