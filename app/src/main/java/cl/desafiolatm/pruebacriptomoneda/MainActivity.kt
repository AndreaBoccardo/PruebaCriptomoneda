package cl.desafiolatm.pruebacriptomoneda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cl.desafiolatm.pruebacriptomoneda.databinding.ActivityMainBinding
import cl.desafiolatm.pruebacriptomoneda.viewmodel.MonedaViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MonedaViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.obtenerMoneda()
    }
}