package com.lnight.graphqlcountries.domain.use_case

import com.lnight.graphqlcountries.domain.CountryClient
import com.lnight.graphqlcountries.domain.SimpleCountry
import javax.inject.Inject

class GetCountries @Inject constructor(
    private val countryClient: CountryClient
) {
    suspend operator fun invoke(): List<SimpleCountry> {
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}