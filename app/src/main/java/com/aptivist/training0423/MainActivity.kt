package com.aptivist.training0423

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aptivist.training0423.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel : CountriesViewModel by viewModels()

   private lateinit var  binding: ActivityMainBinding

   private lateinit var adapter: CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnMainClickMe.setOnClickListener {
            viewModel.loadCountries()
        }

        adapter = CountriesAdapter(this::onItemClicked)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        viewModel.countriesList.observe(this){
            showCountries(it)
        }
    }

     private fun showCountries(countries: List<DTOCountries>) {
        //Show list in the UI
        adapter.submitList(countries)
    }

     private fun onItemClicked(position: Int) {
         val newList =  adapter.currentList.toMutableList()
         newList.removeAt(position)
         adapter.submitList(newList)
    }

}

