package com.lnight.graphqlcountries.presentation.countries_list

import com.lnight.graphqlcountries.domain.DetailedCountry
import com.lnight.graphqlcountries.domain.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null
)
