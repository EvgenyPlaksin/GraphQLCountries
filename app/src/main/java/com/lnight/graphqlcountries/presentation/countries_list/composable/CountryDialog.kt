package com.lnight.graphqlcountries.presentation.countries_list.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.lnight.graphqlcountries.domain.DetailedCountry

@Composable
fun CountryDialog(
    country: DetailedCountry,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val joinedLanguages = remember(country.languages) {
        country.languages.joinToString()
    }
    val languageTitle = remember(country.languages) {
        if (country.languages.size == 1) "Language" else "Languages"
    }

    Dialog(
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = modifier
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = country.emoji,
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = country.name,
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Continent: ${country.continent}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Currency: ${country.currency}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Capital: ${country.capital}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "$languageTitle: $joinedLanguages")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}