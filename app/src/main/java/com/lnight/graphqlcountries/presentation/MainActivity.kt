package com.lnight.graphqlcountries.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lnight.graphqlcountries.presentation.countries_list.CountriesScreen
import com.lnight.graphqlcountries.presentation.ui.theme.GraphQLCountriesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            GraphQLCountriesTheme {
                val systemUiController = rememberSystemUiController()
                val darkColors = !isSystemInDarkTheme()

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        Color.Transparent,
                        darkColors
                    )
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountriesScreen()
                }
            }
        }
    }
}