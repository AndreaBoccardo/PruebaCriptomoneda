package cl.desafiolatm.pruebacriptomoneda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.menu,menu)
        val searchMenu = menu?.findItem(R.id.app_bar_search)
        val searchView = searchMenu?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.filtro.value = query
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText!!.isEmpty())
                {
                    viewModel.filtro.value = ""
                }
                return false
            }

        })
        return false
    }
}