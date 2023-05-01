package com.aptivist.training0423

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountriesViewModel() : ViewModel() {

    private var _countriesList = MutableLiveData<List<DTOCountries>>(emptyList())
    val countriesList : LiveData<List<DTOCountries>>
    get() = _countriesList

    fun loadCountries() {
        val countries = listOf(
            DTOCountries("Mexico", "MX", R.drawable.ic_mexico_flag),
            DTOCountries("USA", "US", R.drawable.ic_usa_flag),
            DTOCountries("Colombia", "CO", R.drawable.ic_colombia_flag),
            DTOCountries("Mexico", "MX", R.drawable.ic_mexico_flag),
            DTOCountries("USA", "US", R.drawable.ic_usa_flag),
            DTOCountries("Colombia", "CO", R.drawable.ic_colombia_flag),
            DTOCountries("Mexico", "MX", R.drawable.ic_mexico_flag),
            DTOCountries("USA", "US", R.drawable.ic_usa_flag),
            DTOCountries("Colombia", "CO", R.drawable.ic_colombia_flag),
            DTOCountries("Mexico", "MX", R.drawable.ic_mexico_flag),
            DTOCountries("USA", "US", R.drawable.ic_usa_flag),
            DTOCountries("Colombia", "CO", R.drawable.ic_colombia_flag),
            DTOCountries("Mexico", "MX", R.drawable.ic_mexico_flag),
            DTOCountries("USA", "US", R.drawable.ic_usa_flag),
            DTOCountries("Colombia", "CO", R.drawable.ic_colombia_flag),
        )
        countries.sortedByDescending { it.name }
        _countriesList.value = countries
    }

}