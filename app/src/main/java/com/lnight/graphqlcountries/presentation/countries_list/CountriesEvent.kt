package com.lnight.graphqlcountries.presentation.countries_list

sealed interface CountriesEvent {
    class OnCountryClick(val code: String): CountriesEvent
    object OnDialogDismiss: CountriesEvent
}