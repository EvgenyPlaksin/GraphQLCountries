package com.lnight.graphqlcountries.presentation.countries_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lnight.graphqlcountries.presentation.countries_list.composable.CountryDialog
import com.lnight.graphqlcountries.presentation.countries_list.composable.CountryItem
import com.lnight.graphqlcountries.presentation.countries_list.composable.TitleSection

@Composable
fun CountriesScreen(
    viewModel: CountriesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TitleSection(titleText = "Countries")
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    item {
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                    items(state.countries) { country ->
                        CountryItem(
                            modifier = Modifier.fillMaxWidth(),
                            country = country,
                            onClick = { viewModel.onEvent(CountriesEvent.OnCountryClick(country.code)) }
                        )
                    }
                }
            }
            if (state.selectedCountry != null) {
                CountryDialog(
                    country = state.selectedCountry!!,
                    onDismiss = { viewModel.onEvent(CountriesEvent.OnDialogDismiss) },
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(MaterialTheme.colorScheme.inverseOnSurface)
                        .padding(16.dp)
                )
            }
        }
    }
}