package com.lnight.graphqlcountries.data

import com.lnight.graphqlcountries.CountriesQuery
import com.lnight.graphqlcountries.CountryQuery
import com.lnight.graphqlcountries.domain.DetailedCountry
import com.lnight.graphqlcountries.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "Unknown capital",
        currency = currency ?: "Unknown currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "Unknown capital"
    )
}
