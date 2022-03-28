package cl.desafiolatm.pruebacriptomoneda.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import cl.desafiolatm.pruebacriptomoneda.R
import cl.desafiolatm.pruebacriptomoneda.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var archivo: SharedPreferences
    private val ARCHIVO_NAME = "mi_preferencia"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)

        archivo = requireActivity().getSharedPreferences(ARCHIVO_NAME, Context.MODE_PRIVATE)

        with(binding){
            btnIngresar.setOnClickListener {
                if (etUsuario.text.isNotEmpty()){
                    val usuario = etUsuario.text.toString()
                    archivo.edit().putString("name", usuario).putBoolean("login", true).commit()
                    Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_listaFragment)
                } else {
                    Toast.makeText(context, getString(R.string.msg_error), Toast.LENGTH_LONG).show()
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(archivo.getBoolean("login",false)){
            Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_listaFragment)
        }
    }


}