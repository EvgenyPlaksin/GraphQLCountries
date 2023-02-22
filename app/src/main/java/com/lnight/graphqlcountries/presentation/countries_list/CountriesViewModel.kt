package com.lnight.graphqlcountries.presentation.countries_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lnight.graphqlcountries.domain.use_case.GetCountries
import com.lnight.graphqlcountries.domain.use_case.GetCountry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountries: GetCountries,
    private val getCountry: GetCountry
): ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            _state.update {
                it.copy(
                    countries = getCountries(),
                    isLoading = false
                )
            }
        }
    }

    fun onEvent(event: CountriesEvent) {
        when(event) {
            is CountriesEvent.OnCountryClick -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(selectedCountry = getCountry(event.code))
                    }
                }
            }
            CountriesEvent.OnDialogDismiss -> {
                _state.update {
                    it.copy(selectedCountry = null)
                }
            }
        }
    }

}