package com.lnight.graphqlcountries.domain.use_case

import com.lnight.graphqlcountries.domain.CountryClient
import com.lnight.graphqlcountries.domain.DetailedCountry
import javax.inject.Inject

class GetCountry @Inject constructor(
    private val countryClient: CountryClient
) {
    suspend operator fun invoke(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}